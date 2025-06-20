package com.webapp.bankingportal.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.webapp.bankingportal.dto.TransactionDTO;
import com.webapp.bankingportal.entity.Transaction;
import com.webapp.bankingportal.mapper.TransactionMapper;
import com.webapp.bankingportal.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;
import lombok.val;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public List<TransactionDTO> getAllTransactionsByAccountNumber(String accountNumber) {
    	LocalDate from = LocalDate.now();
    	LocalDate to = LocalDate.now();
    	Long accountId = null;
        val transactions = transactionRepository
                .findBySourceAccount_AccountNumberOrTargetAccount_AccountNumber(accountNumber, accountNumber);

        val transactionDTOs = transactions.parallelStream()
                .map(transactionMapper::toDto)
                .sorted((t1, t2) -> t2.getTransactionDate().compareTo(t1.getTransactionDate()))
                .collect(Collectors.toList());
        exportAllFormats(accountId, from, to);
        return transactionDTOs;
    }
    
    public void exportAllFormats(Long accountId, LocalDate from, LocalDate to) {
        List<Transaction> txns = transactionRepository
            .findBySourceAccount_AccountNumberOrTargetAccount_AccountNumber(accountId.toString(), accountId.toString());

        generatePdfStatement(accountId, from, to, txns);
        generateExcelStatement(accountId, from, to, txns);
        generateDocStatement(accountId, from, to, txns);
    }

 // --- StatementServiceImpl Enhancements: PDF, DOC, Excel Export ---

    // 1. PDF Generation
    public File generatePdfStatement(Long accountId, LocalDate from, LocalDate to, List<Transaction> transactions) {
        try {
            Document document = new Document();
            File pdfFile = new File("statements/statement_" + accountId + ".pdf");
            PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
            document.open();

            document.add(new Paragraph("Statement for Account ID: " + accountId));
            document.add(new Paragraph("From: " + from + " To: " + to));
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(4);
            table.addCell("Date");
            table.addCell("Description");
            table.addCell("Type");
            table.addCell("Amount");

            for (Transaction tx : transactions) {
                table.addCell(tx.getTimestamp().toString());
                table.addCell(tx.getRemarks().toString());
                table.addCell(tx.getType().toString());
                
            }

            document.add(table);
            document.close();
            return pdfFile;
        } catch (Exception e) {
            throw new RuntimeException("Error generating PDF statement", e);
        }
    }

    // 2. Excel (.xlsx) Generation
    public File generateExcelStatement(Long accountId, LocalDate from, LocalDate to, List<Transaction> transactions) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Statement");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Date");
            header.createCell(1).setCellValue("Description");
            header.createCell(2).setCellValue("Type");
            header.createCell(3).setCellValue("Amount");

            int rowNum = 1;
            for (Transaction tx : transactions) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(tx.getTimestamp());
                row.createCell(1).setCellValue(tx.getRemarks());
                row.createCell(2).setCellValue(tx.getType());
                row.createCell(3).setCellValue(tx.getAmount());
            }

            File file = new File("statements/statement_" + accountId + ".xlsx");
            try (FileOutputStream out = new FileOutputStream(file)) {
                workbook.write(out);
            }
            return file;
        } catch (Exception e) {
            throw new RuntimeException("Error generating Excel statement", e);
        }
    }

    // 3. DOC (Word) Generation
    public File generateDocStatement(Long accountId, LocalDate from, LocalDate to, List<Transaction> transactions) {
        try {
            File file = new File("statements/statement_" + accountId + ".doc");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("Statement for Account ID: " + accountId);
                writer.newLine();
                writer.write("From: " + from + " To: " + to);
                writer.newLine();
                writer.write("\nDate\t\tDescription\t\tType\t\tAmount");
                writer.newLine();

                for (Transaction tx : transactions) {
                    writer.write(tx.getTimestamp()+ "\t" + tx.getRemarks() + "\t" + tx.getType() + "\t" + tx.getAmount());
                    writer.newLine();
                }
            }
            return file;
        } catch (IOException e) {
            throw new RuntimeException("Error generating DOC statement", e);
        }
    }
}

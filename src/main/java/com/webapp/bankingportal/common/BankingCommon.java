package com.webapp.bankingportal.common;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.webapp.bankingportal.dto.CustomerDTO;
import com.webapp.bankingportal.dto.NotificationDTO;
import com.webapp.bankingportal.entity.Customer;
import com.webapp.bankingportal.entity.Statement;

public class BankingCommon {
	
	// 1. Customer Management - Validation and Audit Logging
	private void validateCustomerData(CustomerDTO dto) {
	    if (dto.getName() == null || dto.getName().isBlank()) {
	        throw new IllegalArgumentException("Customer name cannot be empty");
	    }
	    if (dto.getEmail() != null && !dto.getEmail().contains("@")) {
	        throw new IllegalArgumentException("Invalid email format");
	    }
	}

	private void logCustomerAudit(String action, Long customerId) {
	    System.out.println("AUDIT -> Action: " + action + ", Customer ID: " + customerId);
	}

	// 2. Currency Exchange - API Simulation
	private BigDecimal fetchLiveExchangeRate(String source, String target) {
	    // Simulated response
	    return new BigDecimal("1.082");
	}

	private void cacheExchangeRate(String source, String target, BigDecimal rate) {
	    System.out.println("Cached exchange rate for " + source + " to " + target + ": " + rate);
	}


	private String formatBeneficiaryNickname(String nickname) {
	    return nickname == null ? "Unnamed Beneficiary" : nickname.trim().toUpperCase();
	}

	// 4. Transaction - Business Rules and Threshold Check
	private void validateTransactionAmount(BigDecimal amount) {
	    if (amount.compareTo(BigDecimal.ZERO) <= 0) {
	        throw new IllegalArgumentException("Amount must be positive");
	    }
	    if (amount.compareTo(new BigDecimal("100000")) > 0) {
	        System.out.println("ALERT: High-value transaction initiated.");
	    }
	}

	private String generateTransactionReference() {
	    return "TXN-" + System.currentTimeMillis();
	}

	// 5. Loan Management - EMI Calculation and Eligibility Check
	private BigDecimal calculateMonthlyEMI(BigDecimal principal, BigDecimal rate, int months) {
	    BigDecimal monthlyRate = rate.divide(new BigDecimal("1200"), 8, BigDecimal.ROUND_HALF_UP);
	    return principal.multiply(monthlyRate).divide(BigDecimal.ONE.subtract(
	            BigDecimal.ONE.divide((BigDecimal.ONE.add(monthlyRate)).pow(months), 8, BigDecimal.ROUND_HALF_UP)), 2, BigDecimal.ROUND_HALF_UP);
	}

	private void checkLoanEligibility(Customer customer, BigDecimal amount) {
	    if (amount.compareTo(new BigDecimal("2000000")) > 0) {
	        throw new IllegalArgumentException("Loan request exceeds customer eligibility.");
	    }
	}

	// 6. Fixed Deposit - Maturity Handling and Early Closure Fee
	private BigDecimal computeMaturityAmount(BigDecimal principal, BigDecimal rate, int months) {
	    return principal.add(principal.multiply(rate).multiply(new BigDecimal(months)).divide(new BigDecimal(1200), 2, BigDecimal.ROUND_HALF_UP));
	}

	private BigDecimal calculateEarlyClosurePenalty(BigDecimal principal) {
	    return principal.multiply(new BigDecimal("0.01")); // 1% fee
	}

	// 7. Notification - Retry Mechanism and Logging
	private boolean retryNotificationSend(NotificationDTO dto) {
	    int attempts = 0;
	    while (attempts < 3) {
	        attempts++;
	        System.out.println("Attempt " + attempts + " to send: " + dto.getMessage());
	        if (simulateDeliverySuccess()) return true;
	    }
	    return false;
	}

	private boolean simulateDeliverySuccess() {
	    return Math.random() > 0.3; // 70% chance of success
	}

	// 8. Statement Generation - File Path Builder and Archival Marker
	private String buildStatementPath(Long accountId, LocalDate from, LocalDate to) {
	    return "/storage/statements/" + accountId + "_" + from + "_" + to + ".pdf";
	}

	private boolean archiveStatement(Statement stmt) {
	    System.out.println("Archived statement ID " + stmt.getId());
	    return true;
	}

}

package com.webapp.bankingportal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.bankingportal.dto.BeneficiaryDTO;
import com.webapp.bankingportal.entity.Beneficiary;
import com.webapp.bankingportal.repository.BeneficiaryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BeneficiaryServiceImpl implements BeneficiaryService {

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @Override
    public BeneficiaryDTO addBeneficiary(BeneficiaryDTO dto) {
        Beneficiary b = new Beneficiary();
        b.setCustomerId(dto.getCustomerId());
        b.setTargetAccountId(dto.getTargetAccountId());
        b.setNickname(dto.getNickname());
        b.setBankName(dto.getBankName());
        b.setIfscCode(dto.getIfscCode());
        return toDTO(beneficiaryRepository.save(b));
    }

    @Override
    public BeneficiaryDTO getBeneficiaryById(Long id) {
        return beneficiaryRepository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Beneficiary not found"));
    }

    @Override
    public List<BeneficiaryDTO> getBeneficiariesByCustomerId(Long customerId) {
        return beneficiaryRepository.findByCustomerId(customerId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteBeneficiary(Long id) {
        beneficiaryRepository.deleteById(id);
    }

    private BeneficiaryDTO toDTO(Beneficiary b) {
        BeneficiaryDTO dto = new BeneficiaryDTO();
        dto.setId(b.getId());
        dto.setCustomerId(b.getCustomerId());
        dto.setTargetAccountId(b.getTargetAccountId());
        dto.setNickname(b.getNickname());
        dto.setBankName(b.getBankName());
        dto.setIfscCode(b.getIfscCode());
        return dto;
    }
}


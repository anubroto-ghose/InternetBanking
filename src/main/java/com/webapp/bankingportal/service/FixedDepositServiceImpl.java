package com.webapp.bankingportal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.bankingportal.dto.FixedDepositDTO;
import com.webapp.bankingportal.entity.FixedDeposit;
import com.webapp.bankingportal.repository.FixedDepositRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class FixedDepositServiceImpl implements FixedDepositService {

    @Autowired
    private FixedDepositRepository fixedDepositRepository;

    @Override
    public FixedDepositDTO createFixedDeposit(FixedDepositDTO dto) {
        FixedDeposit fd = new FixedDeposit();
        fd.setAccountId(dto.getAccountId());
        fd.setPrincipalAmount(dto.getPrincipalAmount());
        fd.setInterestRate(dto.getInterestRate());
        fd.setTenureInMonths(dto.getTenureInMonths());
        fd.setStartDate(LocalDate.now());
        fd.setMaturityDate(LocalDate.now().plusMonths(dto.getTenureInMonths()));
        fd.setStatus("ACTIVE");
        return toDTO(fixedDepositRepository.save(fd));
    }

    @Override
    public FixedDepositDTO getFixedDepositById(Long id) {
        return fixedDepositRepository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("FD not found"));
    }

    @Override
    public List<FixedDepositDTO> getFixedDepositsByAccountId(Long accountId) {
        return fixedDepositRepository.findByAccountId(accountId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public FixedDepositDTO closeFixedDeposit(Long id) {
        FixedDeposit fd = fixedDepositRepository.findById(id).orElseThrow();
        fd.setStatus("CLOSED");
        return toDTO(fixedDepositRepository.save(fd));
    }

    private FixedDepositDTO toDTO(FixedDeposit fd) {
        FixedDepositDTO dto = new FixedDepositDTO();
        dto.setId(fd.getId());
        dto.setAccountId(fd.getAccountId());
        dto.setPrincipalAmount(fd.getPrincipalAmount());
        dto.setInterestRate(fd.getInterestRate());
        dto.setTenureInMonths(fd.getTenureInMonths());
        dto.setStartDate(fd.getStartDate());
        dto.setMaturityDate(fd.getMaturityDate());
        dto.setStatus(fd.getStatus());
        return dto;
    }
}

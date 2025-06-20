package com.webapp.bankingportal.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.bankingportal.dto.ExchangeRateDTO;
import com.webapp.bankingportal.dto.NotificationDTO;
import com.webapp.bankingportal.entity.Notification;
import com.webapp.bankingportal.repository.NotificationRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public NotificationDTO sendNotification(NotificationDTO dto) {
        Notification n = new Notification();
        n.setRecipientId(dto.getRecipientId());
        n.setType(dto.getType());
        n.setMessage(dto.getMessage());
        n.setStatus("SENT");
        n.setTimestamp(LocalDateTime.now());
        return toDTO(notificationRepository.save(n));
    }

    @Override
    public List<NotificationDTO> getNotificationsByRecipientId(Long recipientId) {
        return notificationRepository.findByRecipientId(recipientId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    private NotificationDTO toDTO(Notification n) {
        NotificationDTO dto = new NotificationDTO();
        dto.setId(n.getId());
        dto.setRecipientId(n.getRecipientId());
        dto.setType(n.getType());
        dto.setMessage(n.getMessage());
        dto.setStatus(n.getStatus());
        dto.setTimestamp(n.getTimestamp());
        return dto;
    }
}


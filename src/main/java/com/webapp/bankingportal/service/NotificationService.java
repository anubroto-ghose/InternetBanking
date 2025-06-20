package com.webapp.bankingportal.service;

import java.util.List;

import com.webapp.bankingportal.dto.NotificationDTO;

public interface NotificationService {
    NotificationDTO sendNotification(NotificationDTO dto);
    List<NotificationDTO> getNotificationsByRecipientId(Long recipientId);
}

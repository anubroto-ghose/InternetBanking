package com.webapp.bankingportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.bankingportal.dto.NotificationDTO;
import com.webapp.bankingportal.service.AccountService;
import com.webapp.bankingportal.service.NotificationService;
import com.webapp.bankingportal.service.TransactionService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<NotificationDTO> sendNotification(@RequestBody NotificationDTO dto) {
        return ResponseEntity.ok(notificationService.sendNotification(dto));
    }

    @GetMapping("/recipient/{recipientId}")
    public List<NotificationDTO> getNotificationsByRecipient(@PathVariable Long recipientId) {
        return notificationService.getNotificationsByRecipientId(recipientId);
    }
}


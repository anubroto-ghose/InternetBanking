package com.webapp.bankingportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.bankingportal.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByRecipientId(Long recipientId);
}

package com.ansari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansari.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {



}

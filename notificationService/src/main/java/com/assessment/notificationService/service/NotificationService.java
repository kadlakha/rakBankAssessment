package com.assessment.notificationService.service;

import org.springframework.stereotype.Service;

import com.assessment.notificationService.model.Notification;

@Service
public class NotificationService {

    public void sendNotification(Notification notification) {
        System.out.println("Notification sent: " + notification);
    }
}

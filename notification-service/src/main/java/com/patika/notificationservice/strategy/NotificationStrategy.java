package com.patika.notificationservice.strategy;

import com.patika.notificationservice.dto.NotificationDTO;

public interface NotificationStrategy {

	void handleNotification(NotificationDTO notificationDTO);
}

package com.patika.notificationservice.strategy;

import com.patika.notificationservice.dto.NotificationDTO;
import com.patika.notificationservice.listener.NotificationListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailNotification implements NotificationStrategy {

	@Override
	public void handleNotification(NotificationDTO notificationDTO) {
		log.info("email bildirimi kuyruktan okundu: {}", notificationDTO);
		
	}

	
}

package com.patika.notificationservice.strategy;

import com.patika.notificationservice.dto.NotificationDTO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class MobileNotification implements NotificationStrategy {

	@Override
	public void handleNotification(NotificationDTO notificationDTO) {
		log.info("mobil bildirimi kuyruktan okundu: {}", notificationDTO);
		
	}

}

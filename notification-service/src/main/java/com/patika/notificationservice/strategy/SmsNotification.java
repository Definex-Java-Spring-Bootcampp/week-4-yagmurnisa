package com.patika.notificationservice.strategy;

import com.patika.notificationservice.dto.NotificationDTO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class SmsNotification implements NotificationStrategy {

	@Override
	public void handleNotification(NotificationDTO notificationDTO) {
		log.info("sms bildirimi kuyruktan okundu: {}", notificationDTO);
		
	}

}

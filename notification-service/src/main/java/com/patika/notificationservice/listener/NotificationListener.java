package com.patika.notificationservice.listener;

import com.patika.notificationservice.dto.NotificationDTO;
import com.patika.notificationservice.dto.enums.NotificationType;
import com.patika.notificationservice.strategy.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationListener {
	
	private NotificationStrategy notificationStrategy;
	
    @RabbitListener(queues = "${rabbitmq.queue}")
    public void sendNotification(NotificationDTO notificationDTO) {
    	
    	if (notificationDTO.getNotificationType().equals(NotificationType.EMAIL)) {
    		notificationStrategy = new EmailNotification();
    	}
    	else if (notificationDTO.getNotificationType().equals(NotificationType.SMS)) {
    		notificationStrategy = new SmsNotification();
    	}
    	else if (notificationDTO.getNotificationType().equals(NotificationType.MOBILE_NOTIFICATION)) {
    		notificationStrategy = new MobileNotification();
    	}
    	if (notificationStrategy != null) {
    		notificationStrategy.handleNotification(notificationDTO);
    	}
    }
}

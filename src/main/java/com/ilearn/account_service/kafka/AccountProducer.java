package com.ilearn.account_service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.ilearn.account_service.model.AccountCreatedEvent;
import com.ilearn.account_service.util.AppConstants;

@Service
public class AccountProducer {

	@Autowired
	private KafkaTemplate<String, AccountCreatedEvent> kafkaTemplate;

	public void publish(AccountCreatedEvent event) {
		kafkaTemplate.send(AppConstants.ACCOUNT_CREATE_TOPIC, event);
		System.out.println("Event Published : " + event);
	}

}

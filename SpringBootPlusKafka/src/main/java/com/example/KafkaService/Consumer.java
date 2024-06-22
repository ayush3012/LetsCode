package com.example.KafkaService;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	@KafkaListener(topics="MyTopic",groupId="MyGroup" , autoStartup="true")
	public void listenToTopic(String receivedMsg)
	{
		System.out.println("Received message is "+ receivedMsg);
	}
}

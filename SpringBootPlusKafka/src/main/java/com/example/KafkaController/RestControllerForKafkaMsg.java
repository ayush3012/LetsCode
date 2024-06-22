package com.example.KafkaController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.KafkaService.Producer;

@RestController
@RequestMapping("/api/rest")
public class RestControllerForKafkaMsg {
	
	@Autowired
	Producer producer;
	
	
	@GetMapping("/producerMsg")
	public String getMessageFromClient(@RequestParam("message") String msg)
	{
		producer.sendMessageToTopic(msg);
		
		System.out.println("sent successfully");
		return "sent successfully";
	}

}

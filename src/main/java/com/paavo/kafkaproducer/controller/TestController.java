package com.paavo.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@GetMapping("/publish")
	public String publish() {
		this.kafkaTemplate.send("my_topic", "Hello Kafka");
		return "success";
	}
}

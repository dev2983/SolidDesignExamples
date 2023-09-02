package com.designs.solid.srp.better.code;

import com.designs.solid.srp.OrderEntity;
import com.designs.solid.srp.org.apache.kafka.KafkaMessagePublisher;
import com.designs.solid.srp.org.apache.kafka.KafkaMessageRequest;
import com.designs.solid.srp.org.apache.kafka.KafkaSendException;

public class OrderMessageSender {

	private KafkaMessagePublisher kafkaMessagePublisher = new KafkaMessagePublisher();
	
	public boolean send(OrderEntity order) {
		KafkaMessageRequest messageRequest = new KafkaMessageRequest(order.toString());
		try {
			kafkaMessagePublisher.send(messageRequest);
		} catch (KafkaSendException e) {
			System.out.println("Could not send order to downtream system");
			return false;
		}
		return true;
	}
}

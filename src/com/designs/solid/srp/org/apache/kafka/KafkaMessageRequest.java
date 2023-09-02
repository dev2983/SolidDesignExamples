package com.designs.solid.srp.org.apache.kafka;

import java.io.Serializable;

public class KafkaMessageRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private String payload;

	public KafkaMessageRequest(String payload) {
		super();
		this.payload = payload;
	}

	public String getPayload() {
		return payload;
	}
	
	
}

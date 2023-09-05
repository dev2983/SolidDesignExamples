package com.designs.solid.srp.better.code.ex2;

public class OrderSendException {
	
	private String message;
	
	public OrderSendException(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}

}

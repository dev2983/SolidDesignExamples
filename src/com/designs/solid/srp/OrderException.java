package com.designs.solid.srp;

public class OrderException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String message;
	private Throwable rootCause;
	
	public OrderException(String msg, Throwable root) {
		this.message = msg;
		this.rootCause = root;
	}
	
	public OrderException(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Throwable getRootCause() {
		return rootCause;
	}

	public void setRootCause(Throwable rootCause) {
		this.rootCause = rootCause;
	}
}

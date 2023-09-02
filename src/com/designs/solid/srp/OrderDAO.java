package com.designs.solid.srp;

import java.sql.SQLException;
import java.util.Random;

public class OrderDAO {

	public int generateId() {
		return new Random().nextInt();
	}
	public OrderEntity getOrderById(int orderId) {
		// DB call to fetch data
		return new OrderEntity();
	}
	
	public OrderEntity save(OrderEntity payload) throws SQLException {
		// DB save call
		return new OrderEntity();
	}
	
	public boolean sendToAudit(OrderEntity order) {
		return true;
	}
	
	
}

package com.designs.solid.srp.better.code;

import java.sql.SQLException;

import com.designs.solid.srp.OrderDAO;
import com.designs.solid.srp.OrderEntity;
import com.designs.solid.srp.OrderException;

public class OrderBusinessService {

	private OrderDAO orderDao = new OrderDAO();
	
	public OrderEntity save(OrderEntity entityToSave) throws OrderException {
		
		try {
			entityToSave = orderDao.save(entityToSave);
			int orderId = orderDao.generateId();
			entityToSave.setOrderId(orderId);
			entityToSave = orderDao.save(entityToSave);
			orderDao.sendToAudit(entityToSave);
			
		} catch (SQLException e) {
			throw new OrderException("Order save failed.. please try again", e);
		}
		return entityToSave;
	}
}

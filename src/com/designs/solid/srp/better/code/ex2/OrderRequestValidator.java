package com.designs.solid.srp.better.code.ex2;

import com.designs.solid.srp.OrderDto;
import com.designs.solid.srp.OrderException;
import com.designs.solid.srp.OrderItemDAO;

public class OrderRequestValidator {

	private OrderItemDAO orderItemDAO = new OrderItemDAO();

	boolean validate(OrderDto request) throws OrderException {
		if (request == null) {
			throw new OrderException("Empty order");
		}
		if (request.getOrderId() <= 0){
			throw new OrderException("Invalid order id");
		}
		if (request.getItemIds() == null || request.getItemIds().size() == 0) {
			throw new OrderException("No order items in this order.");
		}

		boolean anyInvalidItemIdsInOrder = request.getItemIds().stream().filter(itemId -> !orderItemDAO.getOrderItemById(Integer.valueOf(itemId))).
				findAny().isPresent();
		if (anyInvalidItemIdsInOrder) {
			throw new OrderException("Invalid items in this order");
		}
		return true;
	}
}
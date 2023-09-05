package com.designs.solid.srp.problem.code.ex2;

import java.sql.SQLException;
import java.util.Date;

import com.designs.solid.srp.OrderDAO;
import com.designs.solid.srp.OrderDto;
import com.designs.solid.srp.OrderEntity;
import com.designs.solid.srp.OrderException;
import com.designs.solid.srp.OrderItemDAO;
import com.designs.solid.srp.org.apache.kafka.KafkaMessagePublisher;
import com.designs.solid.srp.org.apache.kafka.KafkaMessageRequest;
import com.designs.solid.srp.org.apache.kafka.KafkaSendException;
/**
 *  Example of Violation of Single Responsibility Principle
 */
public class OrderProcessingUtils {

	private OrderDAO orderDAO = new OrderDAO();
	private OrderItemDAO orderItemDAO = new OrderItemDAO();
	private KafkaMessagePublisher kafkaMessagePublisher = new KafkaMessagePublisher();
	
	public boolean validate(OrderDto request) throws OrderException {
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
	
	public OrderEntity map(OrderDto request) {
		
		OrderEntity newEntity = new OrderEntity();
		newEntity.setOrderDate(new Date());
		newEntity.setOrderedBy(request.getOrderedBy());
		newEntity.setPaymentMethodIdentifier(request.getPaymentMethodIdentifier());
		newEntity.setItemIds(request.getItemIds());
		
		return newEntity;
	}
	
	public OrderEntity save(OrderEntity entityToSave) throws OrderException {
		
		try {
			entityToSave = orderDAO.save(entityToSave);
			int orderId = orderDAO.generateId();
			entityToSave.setOrderId(orderId);
			entityToSave = orderDAO.save(entityToSave);
			orderDAO.sendToAudit(entityToSave);
			
		} catch (SQLException e) {
			throw new OrderException("Order save failed.. please try again", e);
		}
		return entityToSave;
	}
	
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

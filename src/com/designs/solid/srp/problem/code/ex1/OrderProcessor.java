package com.designs.solid.srp.problem.code.ex1;

import java.sql.SQLException;
import java.util.Date;

import com.designs.solid.srp.OrderDAO;
import com.designs.solid.srp.OrderDto;
import com.designs.solid.srp.OrderEntity;
import com.designs.solid.srp.OrderItemDAO;
import com.designs.solid.srp.org.apache.kafka.KafkaMessagePublisher;
import com.designs.solid.srp.org.apache.kafka.KafkaMessageRequest;
import com.designs.solid.srp.org.apache.kafka.KafkaSendException;
/**
 *  Example of Violation of Single Responsibility Principle
 */
public class OrderProcessor {

	private OrderDAO orderDAO = new OrderDAO();
	private OrderItemDAO orderItemDAO = new OrderItemDAO();
	private KafkaMessagePublisher kafkaMessagePublisher = new KafkaMessagePublisher();
	
	public OrderEntity processOrder(OrderDto request) throws SQLException, KafkaSendException {
		
		if (request == null || request.getOrderId() <= 0){ throw new IllegalArgumentException("Invalid order id"); }
		if (request.getItemIds() == null || request.getItemIds().size() == 0) {
			throw new IllegalArgumentException("No order items in this order.");
		}
		
		boolean anyInvalidItemIdsInOrder = request.getItemIds().stream()
				.filter(itemId -> !orderItemDAO.getOrderItemById(Integer.valueOf(itemId))).findAny().isPresent();
		
		if (anyInvalidItemIdsInOrder) {
			throw new IllegalArgumentException("Invalid items in this order");
		}
		
		// map to order entity
		OrderEntity newEntity = new OrderEntity();
		newEntity.setOrderDate(new Date());
		newEntity.setOrderedBy(request.getOrderedBy());
		newEntity.setPaymentMethodIdentifier(request.getPaymentMethodIdentifier());
		newEntity.setItemIds(request.getItemIds());
		
		// business and persistence logic
		int orderId = orderDAO.generateId();
		newEntity.setOrderId(orderId);
		newEntity = orderDAO.save(newEntity);
		orderDAO.sendToAudit(newEntity);
		
		// logic to build and send message to downstream Kafka messaging consumer
		String payload = newEntity.toString();
		KafkaMessageRequest messageRequest = new KafkaMessageRequest(payload);
		kafkaMessagePublisher.send(messageRequest);
		
		return newEntity;
	}

}

package com.designs.solid.srp.better.code.ex2;

import com.designs.solid.srp.OrderDto;
import com.designs.solid.srp.OrderEntity;
import com.designs.solid.srp.OrderException;

/**
 *  Example of a Proponent of Single Responsibility Principle acts as a Facade: a single point of contact to reduce the dependencies to all the clients. 
 *  This is an example of how Facade pattern is used.
 */
public class OrderProcessorFacade {

	private OrderMessageSender messageSender = new OrderMessageSender();
	private OrderBusinessService orderBusinessService = new OrderBusinessService();
	
	public OrderEntity processOrder(OrderDto request) throws OrderException {
		
		// validate 
		new OrderRequestValidator().validate(request);
		
		// map to order entity
		OrderEntity entityToSave = new OrderDtoToEntityMapper().map(request);
		
		// business and persistence logic
		entityToSave = orderBusinessService.save(entityToSave);
		
		// logic to build and send message to downstream Kafka messaging consumer
		messageSender.send(entityToSave);
		
		return entityToSave;
	}

}

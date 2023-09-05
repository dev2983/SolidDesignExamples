package com.designs.solid.srp.better.code.ex2;

import java.util.Arrays;
import java.util.Date;

import com.designs.solid.srp.OrderDto;
import com.designs.solid.srp.OrderEntity;
import com.designs.solid.srp.OrderException;

public class OrderProcessingClient2 {

	private OrderMessageSender messageSender = new OrderMessageSender();
	private OrderBusinessService orderBusinessService = new OrderBusinessService();
	public static void main(String[] args) throws OrderException {
		boolean featureFlag = true; // set configuration
		if (featureFlag) {
			new OrderProcessingClient2().processOrderV1();
		} 
		else {
			new OrderProcessingClient2().processOrder();
		}
	}

	private void processOrder() throws OrderException {
		OrderDto orderDto = new OrderDto();
		orderDto.setOrderName("Birthday Order");
		orderDto.setItemIds(Arrays.asList(11, 22, 33));
		orderDto.setOrderDate(new Date());
		
		// validate 
		boolean isValidated = new OrderRequestValidator().validate(orderDto);
		if (!isValidated) {
			System.out.println("Bad order request");
			return;
		}
		
		// map to order entity
		OrderEntity entityToSave = new OrderDtoToEntityMapper().map(orderDto);
		
		// business and persistence logic
		entityToSave = orderBusinessService.save(entityToSave);
		
		// logic to build and send message to downstream Kafka messaging consumer
		messageSender.send(entityToSave);
	}
	
	private void processOrderV1() throws OrderException {
		OrderDto orderDto = new OrderDto();
		orderDto.setOrderName("Birthday Order");
		orderDto.setItemIds(Arrays.asList(11, 22, 33));
		orderDto.setOrderDate(new Date());
		
		OrderEntity processedOrderEntity = new OrderProcessorFacade().processOrder(orderDto);
		System.out.println(processedOrderEntity);
	}

}

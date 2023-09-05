package com.designs.solid.srp.better.code.ex2;

import java.util.Arrays;
import java.util.Date;

import com.designs.solid.srp.OrderDto;
import com.designs.solid.srp.OrderEntity;
import com.designs.solid.srp.OrderException;
import com.designs.solid.srp.problem.code.ex2.OrderProcessingUtils;

public class OrderProcessingClient1 {

	public static void main(String[] args) throws OrderException {
		boolean featureFlag = true; // set configuration
		if (featureFlag) {
			new OrderProcessingClient1().processOrderV1();
		}
		else {
			new OrderProcessingClient1().processOrder();
		}
	}

	private void processOrder() throws OrderException {
		OrderProcessingUtils utils = new OrderProcessingUtils();
		OrderDto orderDto = new OrderDto();
		orderDto.setOrderName("Birthday Order");
		orderDto.setItemIds(Arrays.asList(11, 22, 33));
		orderDto.setOrderDate(new Date());
		
		boolean isValidated = utils.validate(orderDto);
		if (!isValidated) {
			System.out.println("Bad order request");
			return;
		}
		OrderEntity newEntity = utils.map(orderDto);
		
		newEntity = utils.save(newEntity);
		
		utils.send(newEntity);
	}
	
	private void processOrderV1() throws OrderException {
		OrderProcessorFacade orderProcessorFacade = new OrderProcessorFacade();
		OrderDto orderDto = new OrderDto();
		orderDto.setOrderName("Birthday Order");
		orderDto.setItemIds(Arrays.asList(11, 22, 33));
		orderDto.setOrderDate(new Date());
		
		OrderEntity processedOrderEntity = orderProcessorFacade.processOrder(orderDto);
		System.out.println(processedOrderEntity);
	}

}

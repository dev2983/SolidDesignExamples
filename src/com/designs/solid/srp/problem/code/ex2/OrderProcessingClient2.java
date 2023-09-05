package com.designs.solid.srp.problem.code.ex2;

import java.util.Arrays;
import java.util.Date;

import com.designs.solid.srp.OrderDto;
import com.designs.solid.srp.OrderEntity;
import com.designs.solid.srp.OrderException;

public class OrderProcessingClient2 {

	public static void main(String[] args) throws OrderException {
		new OrderProcessingClient2().processOrder();
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

}

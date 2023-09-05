package com.designs.solid.srp.better.code.ex1;

import java.util.Date;

import com.designs.solid.srp.OrderDto;
import com.designs.solid.srp.OrderEntity;

public class OrderDtoToEntityMapper {

	public OrderEntity map(OrderDto request) {
		
		OrderEntity newEntity = new OrderEntity();
		newEntity.setOrderDate(new Date());
		newEntity.setOrderedBy(request.getOrderedBy());
		newEntity.setPaymentMethodIdentifier(request.getPaymentMethodIdentifier());
		newEntity.setItemIds(request.getItemIds());
		
		return newEntity;
	}
}
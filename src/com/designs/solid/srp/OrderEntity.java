package com.designs.solid.srp;

import java.util.Date;
import java.util.List;

public class OrderEntity {

	private int orderId;
	private String orderName;
	private double totalAmount;
	private List<Integer> itemIds;
	private Date orderDate;
	private String orderedBy;
	private String paymentMethodIdentifier;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<Integer> getItemIds() {
		return itemIds;
	}
	public void setItemIds(List<Integer> itemIds) {
		this.itemIds = itemIds;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderedBy() {
		return orderedBy;
	}
	public void setOrderedBy(String orderedBy) {
		this.orderedBy = orderedBy;
	}
	public String getPaymentMethodIdentifier() {
		return paymentMethodIdentifier;
	}
	public void setPaymentMethodIdentifier(String paymentMethodIdentifier) {
		this.paymentMethodIdentifier = paymentMethodIdentifier;
	}
	
	@Override
	public String toString() {
		return this.orderId + "-" + this.orderName+ "-" + this.orderDate.toString();
	}
}

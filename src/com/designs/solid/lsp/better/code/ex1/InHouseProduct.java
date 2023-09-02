package com.designs.solid.lsp.better.code.ex1;

import com.designs.solid.lsp.code.Product;

public class InHouseProduct extends Product {

	public double getDiscount() {
		this.applyAdditionalDiscount();
		return discount;
	}
	
	public void applyAdditionalDiscount() {
		discount = discount * 1.5;
	}
}

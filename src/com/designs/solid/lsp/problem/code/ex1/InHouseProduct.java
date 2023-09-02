package com.designs.solid.lsp.problem.code.ex1;

import com.designs.solid.lsp.code.Product;

public class InHouseProduct extends Product {

	public void applyAdditionalDiscount() {
		discount = discount * 1.5;
	}
}

package com.designs.solid.lsp.problem.code.ex1;

import java.util.ArrayList;
import java.util.List;

import com.designs.solid.lsp.code.Product;

public class PricingDiscountUtils {

	public static void main(String[] args) {
		
		Product mobile = new Product();
		Product book = new Product();
		Product amazonBasicsCharger = new InHouseProduct();
		
		List<Product> products = new ArrayList<>();
		products.add(mobile);
		products.add(book);
		products.add(amazonBasicsCharger);
		
		for (Product product : products) {
			if (product instanceof InHouseProduct) {
				((InHouseProduct) product).applyAdditionalDiscount();
			}
			System.out.println("Discount - " + product.getDiscount());
		}
		
	}

}

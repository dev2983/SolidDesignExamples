package com.designs.solid.dip.better.code;

import java.util.List;

public class ProductCatalog {

	public void listAllProducts() {
		
		ProductRepository productRepository = ProductFactory.create();
		List<String> productNames = productRepository.getProductNames();
		
		productNames.forEach( productName -> System.out.println(productName));
	}
}

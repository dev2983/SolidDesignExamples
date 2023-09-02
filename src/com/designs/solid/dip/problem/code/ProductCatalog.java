package com.designs.solid.dip.problem.code;

import java.util.List;

public class ProductCatalog {

	public void listAllProducts() {
		
		SqlProductRepository sqlProductRepository = new SqlProductRepository();
		List<String> productNames = sqlProductRepository.getProductNames();
		
		productNames.forEach( productName -> System.out.println(productName));
	}
}

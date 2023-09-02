package com.designs.solid.dip.better.code;

import java.util.Arrays;
import java.util.List;

public class SqlProductRepository implements ProductRepository {

	@Override
	public List<String> getProductNames() {
		
		return Arrays.asList("mobiles", "books", "clothes");
	}
}

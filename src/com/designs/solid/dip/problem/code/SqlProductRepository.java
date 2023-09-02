package com.designs.solid.dip.problem.code;

import java.util.Arrays;
import java.util.List;

public class SqlProductRepository {

	public List<String> getProductNames() {
		
		return Arrays.asList("mobiles", "books", "clothes");
	}
}

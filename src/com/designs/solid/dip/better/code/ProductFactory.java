package com.designs.solid.dip.better.code;

public class ProductFactory {

	public static ProductRepository create() {
		return new SqlProductRepository();
	}
}

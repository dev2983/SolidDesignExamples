package com.designs.solid.isp.better.code;

public class CanonPrinter implements PrintFuntion {

	@Override
	public void print() {
		System.out.println("print");

	}

	@Override
	public void getPrintSpoolDetails() {
		System.out.println("getPrintSpoolDetails");

	}

}

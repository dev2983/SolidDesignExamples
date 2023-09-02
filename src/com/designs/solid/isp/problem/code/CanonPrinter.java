package com.designs.solid.isp.problem.code;

public class CanonPrinter implements MultiFunction {

	@Override
	public void print() {
		System.out.println("print");
	}

	@Override
	public void getPrintSpoolDetails() {
		System.out.println("getPrintSpoolDetails");
	}

	@Override
	public void scan() {}

	@Override
	public void scanPhoto() {}

	@Override
	public void fax() {}

	@Override
	public void interentFax() {}

}

package com.designs.solid.isp.problem.code;

public class XeroxMachine implements MultiFunction {

	@Override
	public void print() {
		System.out.println("print");

	}

	@Override
	public void getPrintSpoolDetails() {
		System.out.println("getPrintSpoolDetails");

	}

	@Override
	public void scan() {
		System.out.println("scan");

	}

	@Override
	public void scanPhoto() {
		System.out.println("scanPhoto");

	}

	@Override
	public void fax() {
		System.out.println("fax");

	}

	@Override
	public void interentFax() {
		System.out.println("interentFax");

	}

}
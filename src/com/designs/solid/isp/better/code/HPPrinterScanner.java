package com.designs.solid.isp.better.code;

public class HPPrinterScanner implements PrintFuntion, ScanFunction {

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

}

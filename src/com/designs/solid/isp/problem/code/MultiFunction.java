package com.designs.solid.isp.problem.code;

/**
 * Violation of Interface Segregation Principle
 */
public interface MultiFunction {

	void print();
	void getPrintSpoolDetails();
	void scan();
	void scanPhoto();
	void fax();
	void interentFax();
}

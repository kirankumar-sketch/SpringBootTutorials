package com.dailycodebuffer.springboot.error;

public class DepartmentNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DepartmentNotFoundException(String string) {
		super(string);
	}

}

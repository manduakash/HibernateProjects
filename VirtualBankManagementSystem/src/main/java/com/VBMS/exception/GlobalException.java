package com.VBMS.exception;

public class GlobalException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// constructor overloading
	public GlobalException(String alert) {
		super(alert);			// invoking super class (Exception) overloded constructor 

	}

}

package com.ctrip.lms.exception;

public class LBSException extends Exception {
	private String errorMessage;
	
	public LBSException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

}

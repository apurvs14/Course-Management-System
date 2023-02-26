package com.masai.exception;

@SuppressWarnings("serial")
public class NoRecordFoundException extends Exception{

	public NoRecordFoundException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return getMessage();
	}	
	
}

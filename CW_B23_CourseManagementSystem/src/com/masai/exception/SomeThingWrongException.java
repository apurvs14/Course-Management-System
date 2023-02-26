package com.masai.exception;

@SuppressWarnings("serial")
public class SomeThingWrongException extends Exception {

	@Override
	public String toString() {
		return "Some thing went wrong, try again later";
	}
	
}

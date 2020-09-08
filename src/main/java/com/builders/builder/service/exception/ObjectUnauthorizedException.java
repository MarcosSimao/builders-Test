package com.builders.builder.service.exception;

public class ObjectUnauthorizedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectUnauthorizedException(String msg) {
	super(msg);
	}

}

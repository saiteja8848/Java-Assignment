package com.centime.demorestapi.aspects;

public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public CustomException(String message) {
        super(message);
    }
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

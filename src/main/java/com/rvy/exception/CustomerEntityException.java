package com.rvy.exception;

import org.springframework.web.server.ResponseStatusException;

public class CustomerEntityException extends Exception{
	
	public CustomerEntityException() {
		super();
		System.out.println("Invalid Response");

	}
	
	public CustomerEntityException(String message) {
		super(message);
	}
    public CustomerEntityException(String message,Throwable e) {
        super(message,e);
    }
}

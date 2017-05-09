package com.globant.exceptions;

public class ResourceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2133920634170041612L;

	public ResourceNotFoundException(String message) {
		super("Resource not found for: " + message);
	}
	
}

package com.rays.exception;

/**
 * Exception thrown when attempting to create a record that already exists
 * based on a unique constraint.
 * 
 * @author Aniket Rajput
 */
public class DuplicateRecordException extends RuntimeException{
	
	/**
	 * Constructs a new DuplicateRecordException with the specified message.
	 * 
	 * @param message the detail message
	 */
	public DuplicateRecordException(String message) {
		super(message);
	}

}
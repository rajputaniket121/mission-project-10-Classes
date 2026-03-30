package com.rays.exception;

/**
 * Exception thrown when a requested record is not found in the database.
 * 
 * @author Aniket Rajput
 */
public class RecordNotFoundException extends RuntimeException {

	/**
	 * Constructs a new RecordNotFoundException with the specified message.
	 * 
	 * @param message the detail message
	 */
	public RecordNotFoundException(String message) {
		super(message);
	}

}
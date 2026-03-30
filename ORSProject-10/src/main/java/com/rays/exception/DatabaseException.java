package com.rays.exception;

/**
 * Exception thrown when database operations fail.
 * 
 * @author Aniket Rajput
 */
public class DatabaseException extends RuntimeException{
	
	/**
	 * Constructs a new DatabaseException with the specified message.
	 * 
	 * @param message the detail message
	 */
	public DatabaseException(String message) {
		super(message);
	}

}
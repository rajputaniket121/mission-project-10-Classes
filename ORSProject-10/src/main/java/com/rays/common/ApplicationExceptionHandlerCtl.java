package com.rays.common;

import org.springframework.dao.DataAccessResourceFailureException;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Handles application propagated exceptions across all REST controllers.
 * Provides centralized exception handling for database connectivity issues and
 * runtime exceptions.
 * 
 * @author Aniket Rajput
 */
@RestControllerAdvice
public class ApplicationExceptionHandlerCtl {

	/**
	 * Handles all database related problems including connection failures,
	 * transaction creation issues, and resource access failures.
	 * 
	 * @param e the database exception that was thrown
	 * @return ResponseEntity containing ORSResponse with a user-friendly error
	 *         message and HTTP 503 SERVICE_UNAVAILABLE status
	 */
	@ExceptionHandler({ CannotCreateTransactionException.class, DataAccessResourceFailureException.class,
			JDBCConnectionException.class })
	public ResponseEntity<ORSResponse> handleDatabaseException(Exception e) {
		ORSResponse res = new ORSResponse(false);
		res.addMessage("Database service is currently unavailable. Please try again later.");
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE) // 503
				.body(res);
	}

	/**
	 * Handles all other runtime exceptions that are not specifically handled by
	 * other exception handlers.
	 * 
	 * @param e the runtime exception that was thrown
	 * @return ResponseEntity containing ORSResponse with the exception message and
	 *         HTTP 500 INTERNAL_SERVER_ERROR status
	 */
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ORSResponse> handleRuntimeException(RuntimeException e) {
		ORSResponse res = new ORSResponse(false);
		res.addMessage(e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR) // 500
				.body(res);
	}
}
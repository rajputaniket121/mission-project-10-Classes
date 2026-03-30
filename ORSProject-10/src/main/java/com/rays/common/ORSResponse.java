package com.rays.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Standard response wrapper for all REST API responses.
 * Contains success status and a result map with various data types.
 * 
 * @author Aniket Rajput
 */
public class ORSResponse {
	public static final String INPUT_EROOR = "inputerror";
	public static final String MESSSAGE = "message";
	public static final String DATA = "data";

	private boolean success = false;

	private Map<String, Object> result = new HashMap<String, Object>();

	/**
	 * Default constructor.
	 */
	public ORSResponse() {
	}

	/**
	 * Constructor with success flag.
	 * 
	 * @param success the success status to set
	 */
	public ORSResponse(boolean success) {
		this.success = success;
	}

	/**
	 * Checks if the response indicates success.
	 * 
	 * @return true if successful, false otherwise
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Sets the success status of the response.
	 * 
	 * @param success the success status to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * Gets the result map containing response data.
	 * 
	 * @return the result map
	 */
	public Map<String, Object> getResult() {
		return result;
	}

	/**
	 * Sets the result map for the response.
	 * 
	 * @param result the result map to set
	 */
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	/**
	 * Adds data to the response under the DATA key.
	 * 
	 * @param value the data to add
	 */
	public void addData(Object value) {
		result.put(DATA, value);
	}

	/**
	 * Adds input errors to the response under the INPUT_EROOR key.
	 * 
	 * @param value the input errors to add
	 */
	public void addInputError(Object value) {
		result.put(INPUT_EROOR, value);
	}

	/**
	 * Adds a message to the response under the MESSSAGE key.
	 * 
	 * @param value the message to add
	 */
	public void addMessage(Object value) {
		result.put(MESSSAGE, value);
	}

	/**
	 * Adds a custom key-value pair to the result map.
	 * 
	 * @param key the key for the value
	 * @param value the value to add
	 */
	public void addResult(String key, Object value) {
		result.put(key, value);
	}

}
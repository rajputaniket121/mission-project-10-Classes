package com.rays.common;

/**
 * Interface for dropdown list options. Provides common methods for displaying
 * key-value pairs in dropdown lists.
 * 
 * @author Aniket Rajput
 */
public interface DropdownList {

	/**
	 * Gets the key value for dropdown option.
	 * 
	 * @return the key as a string
	 */
	public String getKey();

	/**
	 * Gets the display value for dropdown option.
	 * 
	 * @return the display value as a string
	 */
	public String getValue();
}
package com.rays.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Form for user login authentication.
 * Captures login credentials with validation.
 * 
 * @author Aniket Rajput
 */
public class LoginForm {

	@NotEmpty(message = "Login Id is required")
	@Email
	private String loginId;

	@NotEmpty(message = "Password is required")
	private String password;

	/**
	 * Gets the login ID (email) for authentication.
	 * 
	 * @return the login ID
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * Sets the login ID (email) for authentication.
	 * 
	 * @param loginId the login ID to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * Gets the password for authentication.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password for authentication.
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
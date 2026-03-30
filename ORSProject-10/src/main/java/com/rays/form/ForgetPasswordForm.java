package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseForm;

/**
 * Form for forgot password functionality. Captures the login ID/email to send
 * password reset instructions.
 * 
 * @author Aniket Rajput
 */
public class ForgetPasswordForm extends BaseForm {

	@NotEmpty(message = "Login Id is required")
	private String loginId;

	/**
	 * Gets the login ID for password recovery.
	 * 
	 * @return the login ID
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * Sets the login ID for password recovery.
	 * 
	 * @param loginId the login ID to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}
package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.rays.common.BaseForm;

/**
 * Form for handling password change requests. Contains old password, new
 * password, and login ID fields with validation.
 * 
 * @author Aniket Rajput
 */
public class ChangePasswordForm extends BaseForm {

	@NotEmpty(message = "Old Password is required")
	@Size(min = 2, max = 10)
	private String oldPassword;

	@NotEmpty(message = "New Password is required")
	@Size(min = 2, max = 10)
	private String newPassword;

	private String loginId;

	/**
	 * Gets the old password.
	 * 
	 * @return the old password
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * Sets the old password.
	 * 
	 * @param oldPassword the old password to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * Gets the new password.
	 * 
	 * @return the new password
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * Sets the new password.
	 * 
	 * @param newPassword the new password to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * Gets the login ID of the user.
	 * 
	 * @return the login ID
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * Sets the login ID of the user.
	 * 
	 * @param loginId the login ID to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}
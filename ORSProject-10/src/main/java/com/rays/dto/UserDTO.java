package com.rays.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Data Transfer Object for User entity. Contains user account information
 * including login credentials, personal details, role assignments, and account
 * status.
 * 
 * @author Aniket Rajput
 */
@Entity
@Table(name = "ST_USER")
public class UserDTO extends BaseDTO {

	@Column(name = "FIRST_NAME", length = 50)
	private String firstName;

	@Column(name = "LAST_NAME", length = 50)
	private String lastName;

	@Column(name = "LOGIN_ID", length = 50)
	private String loginId;

	@Column(name = "PASSWORD", length = 50)
	private String password;

	@Column(name = "ROLE_ID")
	private Long roleId;

	@Column(name = "ROLE_NAME", length = 50)
	private String roleName = null;

	@Column(name = "DOB", length = 50)
	private Date dob;

	@Column(name = "GENDER", length = 50)
	private String gender;

	@Column(name = "PHONE", length = 50)
	private String phone;

	@Column(name = "ALTERNATE_MOBILE", length = 50)
	private String alternateMobile;

	@Column(name = "STATUS", length = 50)
	private String status;

	@Column(name = "LAST_LOGIN")
	private Timestamp lastLogin;

	@Column(name = "UNSUCCESSFULL_LOGIN_ATTEMPT")
	private Integer unsuccessfullLoginAttempt = 0;

	@Column(name = "IMAGE_ID")
	private Long imageId;

	/**
	 * Gets the display value for dropdown lists.
	 * 
	 * @return null as user is not typically used in dropdowns
	 */
	@Override
	public String getValue() {
		return null;
	}

	/**
	 * Gets the unique key attribute name for validation.
	 * 
	 * @return "loginId" as the unique key
	 */
	@Override
	public String getUniqueKey() {
		return "loginId";
	}

	/**
	 * Gets the unique key value for validation.
	 * 
	 * @return the login ID
	 */
	@Override
	public String getUniqueValue() {
		return loginId;
	}

	/**
	 * Gets the display label for this DTO.
	 * 
	 * @return "Login Id" as the label
	 */
	@Override
	public String getLabel() {
		return "Login Id";
	}

	/**
	 * Gets the table name for this DTO.
	 * 
	 * @return "User" as the table name
	 */
	@Override
	public String getTableName() {
		return "User";
	}

	/**
	 * Gets the user's first name.
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the user's first name.
	 * 
	 * @param firstName the first name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the user's last name.
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the user's last name.
	 * 
	 * @param lastName the last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the user's login ID (username).
	 * 
	 * @return the login ID
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * Sets the user's login ID (username).
	 * 
	 * @param loginId the login ID to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * Gets the user's password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the user's password.
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the role ID assigned to the user.
	 * 
	 * @return the role ID
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * Sets the role ID assigned to the user.
	 * 
	 * @param roleId the role ID to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * Gets the role name assigned to the user.
	 * 
	 * @return the role name
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Sets the role name assigned to the user.
	 * 
	 * @param roleName the role name to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * Gets the user's date of birth.
	 * 
	 * @return the date of birth
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets the user's date of birth.
	 * 
	 * @param dob the date of birth to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * Gets the user's gender.
	 * 
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the user's gender.
	 * 
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the user's phone number.
	 * 
	 * @return the phone number
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the user's phone number.
	 * 
	 * @param phone the phone number to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the user's alternate mobile number.
	 * 
	 * @return the alternate mobile number
	 */
	public String getAlternateMobile() {
		return alternateMobile;
	}

	/**
	 * Sets the user's alternate mobile number.
	 * 
	 * @param alternateMobile the alternate mobile number to set
	 */
	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}

	/**
	 * Gets the user's account status (Active/Inactive).
	 * 
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the user's account status.
	 * 
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the timestamp of the user's last login.
	 * 
	 * @return the last login timestamp
	 */
	public Timestamp getLastLogin() {
		return lastLogin;
	}

	/**
	 * Sets the timestamp of the user's last login.
	 * 
	 * @param lastLogin the last login timestamp to set
	 */
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * Gets the count of unsuccessful login attempts.
	 * 
	 * @return the unsuccessful login attempt count
	 */
	public Integer getUnsuccessfullLoginAttempt() {
		return unsuccessfullLoginAttempt;
	}

	/**
	 * Sets the count of unsuccessful login attempts.
	 * 
	 * @param unsuccessfullLoginAttempt the count to set
	 */
	public void setUnsuccessfullLoginAttempt(Integer unsuccessfullLoginAttempt) {
		this.unsuccessfullLoginAttempt = unsuccessfullLoginAttempt;
	}

	/**
	 * Gets the image ID of the user's profile picture.
	 * 
	 * @return the image ID
	 */
	public Long getImageId() {
		return imageId;
	}

	/**
	 * Sets the image ID of the user's profile picture.
	 * 
	 * @param imageId the image ID to set
	 */
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", loginId=" + loginId + ", password="
				+ password + ", roleId=" + roleId + ", roleName=" + roleName + ", dob=" + dob + ", gender=" + gender
				+ ", phone=" + phone + ", alternateMobile=" + alternateMobile + ", status=" + status + ", lastLogin="
				+ lastLogin + ", unsuccessfullLoginAttempt=" + unsuccessfullLoginAttempt + ", imageId=" + imageId + "]";
	}
}
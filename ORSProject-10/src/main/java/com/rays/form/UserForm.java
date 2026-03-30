package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseForm;
import com.rays.dto.UserDTO;

/**
 * Form for User entity. Handles validation and DTO conversion for user account
 * data including personal details, login credentials, role assignment, and
 * account status.
 * 
 * @author Aniket Rajput
 */
public class UserForm extends BaseForm<UserDTO> {

	@NotEmpty(message = "First Name is required")
	private String firstName;

	@NotEmpty(message = "Last Name is required")
	private String lastName;

	@NotEmpty(message = "Login Id is required")
	private String loginId;

	@NotEmpty(message = "Password is required")
	private String password;

	@NotNull(message = "Role is required")
	@Min(1)
	private Long roleId;

	private String roleName = null;

	@NotNull(message = "Date of birth is required")
	private Date dob;

	@NotEmpty(message = "Gender is required")
	private String gender;

	@NotNull(message = "Mobile No is required")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phone;

	@NotEmpty(message = "Alternate Mobile No is required")
	private String alternateMobile;

	@NotEmpty(message = "Status is required")
	private String status;

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
	 * Gets the user's login ID.
	 * 
	 * @return the login ID
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * Sets the user's login ID.
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
	 * Gets the user's primary phone number.
	 * 
	 * @return the phone number
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the user's primary phone number.
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
	 * Gets the user's account status.
	 * 
	 * @return the status (Active/Inactive)
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
	 * Converts the form data to a UserDTO.
	 * 
	 * @return the populated UserDTO
	 */
	@Override
	public UserDTO getDto() {
		UserDTO dto = initDTO(new UserDTO());
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setLoginId(loginId);
		dto.setPassword(password);
		dto.setRoleId(roleId);
		dto.setRoleName(roleName);
		dto.setDob(dob);
		dto.setGender(gender);
		dto.setPhone(phone);
		dto.setAlternateMobile(alternateMobile);
		dto.setStatus(status);
		return dto;
	}

}
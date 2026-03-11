package com.rays.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

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
	private Integer unsuccessfullLoginAttempt = 0 ;
	
	@Column(name = "IMAGE_ID")
	private Long imageId;
	

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public String getUniqueKey() {
		return "loginId";
	}

	@Override
	public String getUniqueValue() {
		return loginId;
	}

	@Override
	public String getLabel() {
		return "Login Id";
	}

	@Override
	public String getTableName() {
		return "User";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAlternateMobile() {
		return alternateMobile;
	}

	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Integer getUnsuccessfullLoginAttempt() {
		return unsuccessfullLoginAttempt;
	}

	public void setUnsuccessfullLoginAttempt(Integer unsuccessfullLoginAttempt) {
		this.unsuccessfullLoginAttempt = unsuccessfullLoginAttempt;
	}

	public Long getImageId() {
		return imageId;
	}

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

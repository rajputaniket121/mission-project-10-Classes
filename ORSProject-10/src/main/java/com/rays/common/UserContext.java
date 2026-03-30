package com.rays.common;

import com.rays.dto.UserDTO;

/**
 * User context holder containing information about the currently authenticated user.
 * Used for audit tracking and authorization checks.
 * 
 * @author Aniket Rajput
 */
public class UserContext {
	
	private Long userId = 0l;
	private String loginId = "root";
	private String name = null;
	private Long roleId = 0L;
	private String roleName = "root";
	
	private UserDTO userDto = null;
	
	/**
	 * Default constructor.
	 */
	public UserContext() {
	}
	
	/**
	 * Constructor that populates user context from a UserDTO.
	 * 
	 * @param dto the UserDTO containing user information
	 */
	public UserContext(UserDTO dto) {
		this.userDto = dto;
		this.userId = dto.getId();
		this.loginId = dto.getLoginId();
		this.name = dto.getFirstName()+" "+dto.getLastName();
		this.roleId = dto.getRoleId();
		this.roleName = dto.getRoleName();
	}

	/**
	 * Gets the user ID.
	 * 
	 * @return the user ID
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Sets the user ID.
	 * 
	 * @param userId the user ID to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Gets the login ID.
	 * 
	 * @return the login ID
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * Sets the login ID.
	 * 
	 * @param loginId the login ID to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * Gets the user's full name.
	 * 
	 * @return the user's full name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the user's full name.
	 * 
	 * @param name the full name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the user's role ID.
	 * 
	 * @return the role ID
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * Sets the user's role ID.
	 * 
	 * @param roleId the role ID to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * Gets the user's role name.
	 * 
	 * @return the role name
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Sets the user's role name.
	 * 
	 * @param roleName the role name to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * Gets the complete UserDTO.
	 * 
	 * @return the UserDTO
	 */
	public UserDTO getUserDto() {
		return userDto;
	}

	/**
	 * Sets the complete UserDTO.
	 * 
	 * @param userDto the UserDTO to set
	 */
	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}

	@Override
	public String toString() {
		return "UserContext [userId=" + userId + ", loginId=" + loginId + ", name=" + name + ", roleId=" + roleId
				+ ", roleName=" + roleName + ", userDto=" + userDto + "]";
	}
}
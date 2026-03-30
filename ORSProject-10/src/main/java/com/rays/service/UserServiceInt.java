package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.UserDTO;

/**
 * Service interface for User entity.
 * Provides business logic operations for user management including
 * authentication, registration, password management, and profile operations.
 * 
 * @author Aniket Rajput
 */
public interface UserServiceInt extends BaseServiceInt<UserDTO> {
	
	/**
	 * Finds a user by their login ID.
	 * 
	 * @param name the login ID to search for
	 * @param userContext the user context
	 * @return the user DTO if found, null otherwise
	 */
	public UserDTO findByLoginId(String name, UserContext userContext);

	/**
	 * Registers a new user account.
	 * Sends a confirmation email upon successful registration.
	 * 
	 * @param dto the user DTO to register
	 * @param userContext the user context
	 * @return the registered user DTO
	 */
	public UserDTO register(UserDTO dto, UserContext userContext);

	/**
	 * Authenticates a user with login ID and password.
	 * Updates login attempt tracking and last login timestamp.
	 * 
	 * @param loginId the user's login ID
	 * @param password the user's password
	 * @return the authenticated user DTO, null if authentication fails
	 */
	public UserDTO authenticate(String loginId, String password);

	/**
	 * Handles forgot password functionality.
	 * Sends the password to the registered email address.
	 * 
	 * @param loginId the login ID for password recovery
	 * @return the user DTO if found, null otherwise
	 */
	public UserDTO forgotPassword(String loginId);

	/**
	 * Changes the user's password after validating the old password.
	 * Sends a confirmation email upon successful password change.
	 * 
	 * @param loginId the user's login ID
	 * @param oldPassword the current password
	 * @param newPassword the new password to set
	 * @param userContext the user context
	 * @return the updated user DTO, null if old password is invalid
	 */
	public UserDTO changePassword(String loginId, String oldPassword, String newPassword, UserContext userContext);

}
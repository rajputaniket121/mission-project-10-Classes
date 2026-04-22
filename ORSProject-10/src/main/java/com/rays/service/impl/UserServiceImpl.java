package com.rays.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.UserContext;
import com.rays.common.impl.BaseServiceImpl;
import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;
import com.rays.utill.EmailBuilder;
import com.rays.utill.EmailMessage;
import com.rays.utill.EmailUtility;

/**
 * Implementation of UserServiceInt interface.
 * Provides business logic operations for user management including
 * authentication, registration, password management, and email notifications.
 * 
 * @author Aniket Rajput
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserDTO,UserDAOInt> implements UserServiceInt {
	
	/**
	 * Finds a user by their login ID.
	 * 
	 * @param login the login ID to search for
	 * @param userContext the user context
	 * @return the user DTO if found, null otherwise
	 */
	@Transactional(readOnly = true)
	public UserDTO findByLoginId(String login, UserContext userContext) {
		return dao.findByUniqueKey("loginId", login, userContext);
	}

	/**
	 * Registers a new user account.
	 * Sends a confirmation email with login credentials upon successful registration.
	 * 
	 * @param dto the user DTO to register
	 * @param userContext the user context
	 * @return the registered user DTO
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDTO register(UserDTO dto, UserContext userContext) {

		Long id = add(dto, userContext);

		dto.setId(id);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", dto.getLoginId());
		map.put("password", dto.getPassword());

		String message = EmailBuilder.getUserRegistrationMessage(map);

		EmailMessage msg = new EmailMessage();

		msg.setTo(dto.getLoginId());
		msg.setSubject("Registration is successful for ORSProject10 RAYS Technologies");
		msg.setMessage(message);
		msg.setMessageType(EmailMessage.HTML_MSG);

		EmailUtility.sendMail(msg);
		

		return dto;
	}

	/**
	 * Authenticates a user with login ID and password.
	 * Updates unsuccessful login attempts and last login timestamp.
	 * 
	 * @param loginId the user's login ID
	 * @param password the user's password
	 * @return the authenticated user DTO, null if authentication fails
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDTO authenticate(String loginId, String password) {

		UserDTO dto = findByLoginId(loginId, null);

		if (dto != null) {
			UserContext userContext = new UserContext(dto);
			if (password.equals(dto.getPassword())) {
				dto.setLastLogin(new Timestamp((new Date()).getTime()));
				dto.setUnsuccessfullLoginAttempt(0);
				update(dto, userContext);
				return dto;
			} else {
				dto.setUnsuccessfullLoginAttempt(1 + dto.getUnsuccessfullLoginAttempt());
				update(dto, userContext);
			}
		}
		return null;
	}

	/**
	 * Handles forgot password functionality.
	 * Sends the password to the registered email address.
	 * 
	 * @param loginId the login ID for password recovery
	 * @return the user DTO if found, null otherwise
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDTO forgotPassword(String loginId) {

		UserDTO dto = findByLoginId(loginId, null);
		if (dto == null) {
			return null;
		}
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", dto.getLoginId());
		map.put("password", dto.getPassword());
		map.put("firstName", dto.getFirstName());
		map.put("lastName", dto.getLastName());
		String message = EmailBuilder.getForgetPasswordMessage(map);
		EmailMessage msg = new EmailMessage();
		msg.setTo(dto.getLoginId());
		msg.setSubject("Rays ORS Password reset");
		msg.setMessage(message);
		msg.setMessageType(EmailMessage.HTML_MSG);
		EmailUtility.sendMail(msg);
		
		return dto;
	}

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
	@Override
	@Transactional(readOnly = true)
	public UserDTO changePassword(String loginId, String oldPassword, String newPassword, UserContext userContext) {

		UserDTO dto = findByLoginId(loginId, userContext);

		if (dto != null && oldPassword.equals(dto.getPassword())) {
			dto.setPassword(newPassword);
			update(dto, userContext);
			
			HashMap<String, String> map = new HashMap<String, String>();

			map.put("login", dto.getLoginId());
			map.put("password", dto.getPassword());
			map.put("firstName", dto.getFirstName());
			map.put("lastName", dto.getLastName());

			String message = EmailBuilder.getChangePasswordMessage(map);

			EmailMessage msg = new EmailMessage();

			msg.setTo(dto.getLoginId());
			msg.setSubject("Password has been changed Successfully.");
			msg.setMessage(message);
			msg.setMessageType(EmailMessage.HTML_MSG);

			EmailUtility.sendMail(msg);
			
			return dto;
		} else {
			return null;
		}
	}
}
package com.rays.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.common.UserContext;
import com.rays.config.JWTUtil;
import com.rays.dto.UserDTO;
import com.rays.form.ForgetPasswordForm;
import com.rays.form.LoginForm;
import com.rays.form.UserForm;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserServiceInt;

/**
 * Authentication Controller for handling login, signup, logout, and password
 * operations. Provides REST endpoints for user authentication and registration.
 * 
 * @author Aniket Rajput
 */
@RestController
@RequestMapping(value = "Auth")
public class LoginCtl extends BaseCtl<UserDTO, UserForm, UserServiceInt> {

	@Autowired
	private JWTUtil jwtUtil;

	/**
	 * Authenticates a user with login credentials.
	 * 
	 * @param form          the login form containing loginId and password
	 * @param bindingResult validation result
	 * @param session       the HTTP session
	 * @param request       the HTTP request
	 * @return ORSResponse with user details and JWT token on success, or error
	 *         message on failure
	 * @throws Exception if token generation fails
	 */
	@PostMapping("login")
	public ORSResponse login(@RequestBody @Valid LoginForm form, BindingResult bindingResult, HttpSession session,
			HttpServletRequest request) throws Exception {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		UserDTO dto = service.authenticate(form.getLoginId(), form.getPassword());

		if (dto == null) {
			res.setSuccess(false);
			res.addMessage("Invalid Login ID & Password");
		} else {
			UserContext context = new UserContext(dto);

			String token = jwtUtil.generateToken(dto.getId(), dto.getLoginId(), dto.getRoleName());

			res.setSuccess(true);
			res.addData(dto);
			res.addResult("loginId", dto.getLoginId());
			res.addResult("role", dto.getRoleName());
			res.addResult("fname", dto.getFirstName());
			res.addResult("lname", dto.getLastName());
			res.addResult("token", token);
			return res;
		}
		return res;
	}

	/**
	 * Registers a new user account.
	 * 
	 * @param form          the registration form containing user details
	 * @param bindingResult validation result
	 * @return ORSResponse with success message or error if loginId already exists
	 */
	@PostMapping("signUp")
	public ORSResponse signUp(@RequestBody @Valid UserRegistrationForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		UserDTO dto = service.findByLoginId(form.getLoginId(), userContext);

		if (dto != null) {
			res.setSuccess(false);
			res.addMessage("Login Id already exists");
			return res;
		}

		dto = new UserDTO();
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLoginId(form.getLoginId());
		dto.setPassword(form.getPassword());
		dto.setDob(form.getDob());
		dto.setGender(form.getGender());
		dto.setPhone(form.getPhone());

		dto.setStatus("Inactive");
		dto.setRoleId(2L);

		service.register(dto, userContext);

		res.setSuccess(true);
		res.addMessage("User has been registered successfully..!!");
		return res;
	}

	/**
	 * Logs out the current user by invalidating the session.
	 * 
	 * @param session the HTTP session to invalidate
	 * @return ORSResponse with logout success message
	 * @throws Exception if session invalidation fails
	 */
	@GetMapping("logout")
	public ORSResponse logout(HttpSession session) throws Exception {

		ORSResponse res = new ORSResponse();

		session.invalidate();

		res.addMessage("Logout successfully..!!");

		return res;
	}

	/**
	 * Handles forgot password functionality by sending password to registered
	 * email.
	 * 
	 * @param form          the forget password form containing loginId
	 * @param bindingResult validation result
	 * @return ORSResponse with success message if loginId exists, or error if not
	 *         found
	 */
	@PostMapping("forgetPassword")
	public ORSResponse forgetPassword(@RequestBody @Valid ForgetPasswordForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		UserDTO fDto = service.forgotPassword(form.getLoginId());

		if (fDto == null) {
			res.setSuccess(false);
			res.addMessage("LoginId / Email not found.");
			return res;
		} else {
			res.setSuccess(true);
			res.addMessage("Hello " + fDto.getFirstName() + " " + fDto.getLastName()
					+ "..! Your password has been sent on your email.");
		}
		return res;
	}
}
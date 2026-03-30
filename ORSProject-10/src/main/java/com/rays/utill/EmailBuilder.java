package com.rays.utill;

import java.util.HashMap;

import org.springframework.stereotype.Component;

/**
 * EmailBuilder is used to build email messages for various notifications.
 * Provides static methods to construct HTML email templates for user
 * registration, forgot password, and change password scenarios.
 * 
 * @author Aniket Rajput
 */
@Component
public class EmailBuilder {
	
	/**
	 * Returns HTML message for successful user registration.
	 * Includes login credentials and welcome message.
	 *
	 * @param map contains message parameters with keys "login" and "password"
	 * @return HTML formatted registration confirmation email
	 */
	public static String getUserRegistrationMessage(HashMap<String, String> map) {
		StringBuilder msg = new StringBuilder();

		msg.append("<HTML><BODY>");
		msg.append("Registration is successful for ORS Project");
		msg.append("<H1>Hi! Greetings from SUNRAYS Technologies!</H1>");
		msg.append(
				"<P>Congratulations for registering on ORS! You can now access your ORS account online - anywhere, anytime and enjoy the flexibility to check the Marksheet Details.</P>");
		msg.append(
				"<P>Log in with your following credentials:</P>");
		msg.append("<P><B>Login Id : " + map.get("login") + "<BR>" + " Password : " + map.get("password") + "</B></p>");

		msg.append(
				"<P> As a security measure, we recommended that you change your password after you first log in.</p>");
		msg.append(
				"<p>For any assistance, please feel free to call us at +91 98273 60884 or 0731-4249244 helpline numbers.</p>");
		msg.append("<p>You may also write to us at hrd@sunrays.co.in.</p>");
		msg.append(
				"<p>We assure you the best service at all times and look forward to a warm and long-standing association with you.</p>");
		msg.append("");
		msg.append("</BODY></HTML>");

		return msg.toString();
	}

	/**
	 * Returns HTML message for forgot password functionality.
	 * Sends the user's login credentials to their registered email.
	 *
	 * @param map contains message parameters with keys "login", "password", "firstName", "lastName"
	 * @return HTML formatted password recovery email
	 */
	public static String getForgetPasswordMessage(HashMap<String, String> map) {
		StringBuilder msg = new StringBuilder();

		msg.append("<HTML><BODY>");
		msg.append("<H1>Your password has been recovered !! " + map.get("firstName") + " " + map.get("lastName") + "</H1>");
		msg.append("<P><B>To access account user Login Id : " + map.get("login") + "<BR>" + " Password : "
				+ map.get("password") + "</B></p>");
		msg.append("</BODY></HTML>");

		return msg.toString();
	}

	/**
	 * Returns HTML message for password change confirmation.
	 * Notifies the user that their password has been successfully changed.
	 *
	 * @param map contains message parameters with keys "login", "password", "firstName", "lastName"
	 * @return HTML formatted password change confirmation email
	 */
	public static String getChangePasswordMessage(HashMap<String, String> map) {
		StringBuilder msg = new StringBuilder();

		msg.append("<HTML><BODY>");
		msg.append("<H1>Your Password has been changed Successfully !! " + map.get("firstName") + " "
				+ map.get("lastName") + "</H1>");
		msg.append("<P><B>To access account user Login Id : " + map.get("login") + "<BR>" + " Password : "
				+ map.get("password") + "</B></p>");
		msg.append("</BODY></HTML>");

		return msg.toString();
	}

}
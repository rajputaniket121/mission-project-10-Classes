package com.rays.common;

/**
 * ThreadLocal holder for UserContext to maintain user information
 * throughout the request processing lifecycle.
 * 
 * @author Aniket Rajput
 */
public class UserContextHolder {

	private static final ThreadLocal<UserContext> threadLocal = new ThreadLocal<>();

	/**
	 * Sets the UserContext for the current thread.
	 * 
	 * @param context the UserContext to set
	 */
	public static void setContext(UserContext context) {
		threadLocal.set(context);
	}

	/**
	 * Gets the UserContext for the current thread.
	 * 
	 * @return the UserContext for the current thread, or null if not set
	 */
	public static UserContext getContext() {
		return threadLocal.get();
	}

	/**
	 * Clears the UserContext for the current thread.
	 * Should be called after request processing to prevent memory leaks.
	 */
	public static void clear() {
		threadLocal.remove();
	}
}
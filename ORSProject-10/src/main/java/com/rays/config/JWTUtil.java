package com.rays.config;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class for JWT token generation, validation, and claim extraction.
 * Implements JWT with HMAC-SHA256 signing.
 * 
 * @author Aniket Rajput
 */
@Component
public class JWTUtil {

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.expiration}")
	private long jwtExpiration; // in milliseconds

	private static final ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * Generates a JWT token for the given user details.
	 * 
	 * @param userId the user ID
	 * @param loginId the login ID (subject)
	 * @param role the user role
	 * @return the generated JWT token as a string
	 * @throws Exception if token generation fails
	 */
	public String generateToken(Long userId, String loginId, String role) throws Exception {
		long nowMillis = System.currentTimeMillis();
		long expMillis = nowMillis + jwtExpiration;

		// JWT Header
		Map<String, Object> header = new HashMap<>();
		header.put("alg", "HS256");
		header.put("typ", "JWT");

		// JWT Payload (claims)
		Map<String, Object> payload = new HashMap<>();
		payload.put("sub", loginId); // loginId as subject
		payload.put("userId", userId); // numeric user id
		payload.put("role", role); // user role
		payload.put("iat", nowMillis); // issued at
		payload.put("exp", expMillis); // expiration

		String headerBase64 = encodeUrl(objectMapper.writeValueAsString(header));
		String payloadBase64 = encodeUrl(objectMapper.writeValueAsString(payload));
		String signatureBase64 = sign(headerBase64 + "." + payloadBase64, jwtSecret);

		return String.join(".", headerBase64, payloadBase64, signatureBase64);
	}

	/**
	 * Validates the JWT token against expected login ID and signature.
	 * 
	 * @param token the JWT token to validate
	 * @param expectedLoginId the expected login ID from the subject claim
	 * @return true if token is valid
	 * @throws Exception if validation fails
	 */
	public boolean validateToken(String token, String expectedLoginId) throws Exception {
		String[] parts = token.split("\\.");
		if (parts.length != 3) {
			throw new Exception("Invalid JWT token");
		}

		String payloadJson = decode(parts[1]);
		String tokenLoginId = extractField(payloadJson, "sub");
		String expectedSignature = sign(parts[0] + "." + parts[1], jwtSecret);

		if (!expectedSignature.equals(parts[2])) {
			throw new Exception("JWT signature does not match");
		}

		if (!expectedLoginId.equals(tokenLoginId)) {
			throw new Exception("JWT subject (loginId) does not match");
		}

		if (isTokenExpired(payloadJson)) {
			throw new Exception("JWT token has expired");
		}

		return true;
	}

	/**
	 * Extracts the login ID (subject) from the JWT token.
	 * 
	 * @param token the JWT token
	 * @return the login ID from the subject claim
	 */
	public String extractLoginId(String token) {
		return extractField(decode(token.split("\\.")[1]), "sub");
	}

	/**
	 * Extracts the user ID from the JWT token.
	 * 
	 * @param token the JWT token
	 * @return the user ID from the payload
	 */
	public Long extractUserId(String token) {
		return Long.parseLong(extractField(decode(token.split("\\.")[1]), "userId"));
	}

	/**
	 * Extracts the role from the JWT token.
	 * 
	 * @param token the JWT token
	 * @return the role from the payload
	 */
	public String extractRole(String token) {
		return extractField(decode(token.split("\\.")[1]), "role");
	}

	/**
	 * Checks if the token has expired.
	 * 
	 * @param payloadJson the JSON payload string
	 * @return true if token has expired, false otherwise
	 */
	private boolean isTokenExpired(String payloadJson) {
		long exp = Long.parseLong(extractField(payloadJson, "exp"));
		return exp < (System.currentTimeMillis() / 1000);
	}

	/**
	 * Extracts a field value from JSON payload.
	 * 
	 * @param json the JSON string
	 * @param field the field name to extract
	 * @return the field value as a string
	 */
	private String extractField(String json, String field) {
		try {
			Map<String, Object> map = objectMapper.readValue(json, Map.class);
			return String.valueOf(map.get(field));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Creates HMAC-SHA256 signature for the data using the key.
	 * 
	 * @param data the data to sign
	 * @param key the secret key
	 * @return the base64 URL encoded signature
	 * @throws Exception if signing fails
	 */
	private String sign(String data, String key) throws Exception {
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
		return encodeUrl(mac.doFinal(data.getBytes(StandardCharsets.UTF_8)));
	}

	/**
	 * Encodes a string to base64 URL format without padding.
	 * 
	 * @param data the string to encode
	 * @return the base64 URL encoded string
	 */
	private String encodeUrl(String data) {
		return Base64.getUrlEncoder().withoutPadding().encodeToString(data.getBytes(StandardCharsets.UTF_8));
	}

	/**
	 * Encodes byte array to base64 URL format without padding.
	 * 
	 * @param data the byte array to encode
	 * @return the base64 URL encoded string
	 */
	private String encodeUrl(byte[] data) {
		return Base64.getUrlEncoder().withoutPadding().encodeToString(data);
	}

	/**
	 * Decodes a base64 URL string.
	 * 
	 * @param data the base64 URL encoded string
	 * @return the decoded string
	 */
	private String decode(String data) {
		return new String(Base64.getUrlDecoder().decode(data), StandardCharsets.UTF_8);
	}
}
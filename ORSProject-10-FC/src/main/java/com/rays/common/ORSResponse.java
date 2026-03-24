package com.rays.common;

import java.util.HashMap;
import java.util.Map;

public class ORSResponse {
	public static final String INPUT_EROOR = "inputerror";
	public static final String MESSSAGE = "message";
	public static final String DATA = "data";

	private boolean success = false;

	private Map<String, Object> result = new HashMap<String, Object>();

	public ORSResponse() {
	}

	public ORSResponse(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public void addData(Object value) {
		result.put(DATA, value);
	}

	public void addInputError(Object value) {
		result.put(INPUT_EROOR, value);
	}

	public void addMessage(Object value) {
		result.put(MESSSAGE, value);
	}

	public void addResult(String key, Object value) {
		result.put(key, value);
	}

}

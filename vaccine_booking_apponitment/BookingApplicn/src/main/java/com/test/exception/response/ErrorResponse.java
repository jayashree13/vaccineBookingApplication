package com.test.exception.response;

public class ErrorResponse {

	private int responseCode;
	private String message;
	private String status;
	private Object data;

	public ErrorResponse(int responseCode, String message) {
		this.responseCode = responseCode;
		this.message = message;
	}

	public ErrorResponse(int responseCode, String message, String status) {
		this.responseCode = responseCode;
		this.message = message;
		this.status = status;
	}
	
	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ErrorResponse [responseCode=" + responseCode + ", message=" + message + ", status=" + status + ", data="
				+ data + "]";
	}

}

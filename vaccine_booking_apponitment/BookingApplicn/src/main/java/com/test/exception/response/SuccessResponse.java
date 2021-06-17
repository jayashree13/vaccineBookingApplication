package com.test.exception.response;

public class SuccessResponse {

	private String status;

	private Object data;

	private String message;

	private int responseCode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SuccessResponse(String status, Object data, String message) {
		super();
		this.status = status;
		this.data = data;
		this.message = message;
	}
	public SuccessResponse(int responseCode, String message) {
		this.responseCode = responseCode;
		this.message = message;
	}

	public SuccessResponse(int responseCode, String message, String status,Object data) {
		this.responseCode = responseCode;
		this.message = message;
		this.status = status;
		this.data = data;
	}
	public SuccessResponse(int responseCode, String message, String status) {
		this.responseCode = responseCode;
		this.message = message;
		this.status = status;
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
	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	@Override
	public String toString() {
		return "SuccessResponse [status=" + status + ", data=" + data + ", message=" + message + "]";
	}

}

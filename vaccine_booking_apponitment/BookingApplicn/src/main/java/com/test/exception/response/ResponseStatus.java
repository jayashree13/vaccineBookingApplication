package com.test.exception.response;


public enum ResponseStatus {
	
	SUCCESS("success"), ERROR("error");

	private String status;

	private ResponseStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}

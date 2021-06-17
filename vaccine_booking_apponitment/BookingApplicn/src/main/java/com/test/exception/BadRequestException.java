package com.test.exception;

import com.test.exception.response.ResponseMessage;

public class BadRequestException extends RuntimeException {
	
private static final long serialVersionUID = 6880261141168398263L;
	
	private ResponseMessage catalystResponseMessage;

	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException(Throwable throwable) {
		super(throwable);
	}
	
	public BadRequestException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public BadRequestException(ResponseMessage catalystResponseMessage) {
		super(catalystResponseMessage.getMessage());
		this.catalystResponseMessage = catalystResponseMessage;
	}
	
	public BadRequestException(ResponseMessage catalystResponseMessage, Throwable throwable) {
		super(catalystResponseMessage.getMessage(), throwable);
		this.catalystResponseMessage = catalystResponseMessage;
	}

	public ResponseMessage getCatalystResponseMessage() {
		return catalystResponseMessage;
	}

}

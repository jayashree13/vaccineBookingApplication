package com.test.exception;

import com.test.exception.response.ResponseMessage;

public class AlreadyExistException extends RuntimeException {

private static final long serialVersionUID = 6880261141168398263L;

	private ResponseMessage catalystResponseMessage;

	public AlreadyExistException(String message) {
		super(message);
	}

	public AlreadyExistException(Throwable throwable) {
		super(throwable);
	}

	public AlreadyExistException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public AlreadyExistException(ResponseMessage catalystResponseMessage) {
		super(catalystResponseMessage.getMessage());
		this.catalystResponseMessage = catalystResponseMessage;
	}

	public AlreadyExistException(ResponseMessage catalystResponseMessage, Throwable throwable) {
		super(catalystResponseMessage.getMessage(), throwable);
		this.catalystResponseMessage = catalystResponseMessage;
	}

	public ResponseMessage getCatalystResponseMessage() {
		return catalystResponseMessage;
	}

}

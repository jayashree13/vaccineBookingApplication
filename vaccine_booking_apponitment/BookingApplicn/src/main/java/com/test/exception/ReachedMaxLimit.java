package com.test.exception;

import com.test.exception.response.ResponseMessage;

public class ReachedMaxLimit extends RuntimeException {

private static final long serialVersionUID = 6880261141168398263L;

	private ResponseMessage catalystResponseMessage;

	public ReachedMaxLimit(String message) {
		super(message);
	}

	public ReachedMaxLimit(Throwable throwable) {
		super(throwable);
	}

	public ReachedMaxLimit(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ReachedMaxLimit(ResponseMessage catalystResponseMessage) {
		super(catalystResponseMessage.getMessage());
		this.catalystResponseMessage = catalystResponseMessage;
	}

	public ReachedMaxLimit(ResponseMessage catalystResponseMessage, Throwable throwable) {
		super(catalystResponseMessage.getMessage(), throwable);
		this.catalystResponseMessage = catalystResponseMessage;
	}

	public ResponseMessage getCatalystResponseMessage() {
		return catalystResponseMessage;
	}

}

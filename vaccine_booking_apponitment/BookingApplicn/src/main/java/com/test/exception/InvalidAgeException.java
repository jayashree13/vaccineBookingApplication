package com.test.exception;

import com.test.exception.response.ResponseMessage;
import com.test.exception.response.SuccessResponse;

public class InvalidAgeException  extends RuntimeException{
    private ResponseMessage responseMessage;

    public InvalidAgeException(String message) {
	super(message);
    }

    public InvalidAgeException(Throwable throwable) {
	super(throwable);
    }

    public InvalidAgeException(String message, Throwable throwable) {
	super(message, throwable);
    }

    public InvalidAgeException(ResponseMessage responseMessage) {
	super(responseMessage.getMessage());
	this.responseMessage = responseMessage;
    }

    public InvalidAgeException(ResponseMessage responseMessage, Throwable throwable) {
	super(responseMessage.getMessage(), throwable);
	this.responseMessage = responseMessage;
    }

    public ResponseMessage getResponseMessage() {
	return responseMessage;
    }

}

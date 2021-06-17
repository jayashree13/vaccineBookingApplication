package com.test.exception.handler;

import com.test.exception.AlreadyExistException;
import com.test.exception.BadRequestException;
import com.test.exception.InvalidAgeException;
import com.test.exception.ReachedMaxLimit;
import com.test.exception.response.ErrorResponse;
import com.test.exception.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidAgeException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleInvalidAgeError(final InvalidAgeException exception) {
        ResponseMessage catalystResponseMessage = exception.getResponseMessage() == null
                        ? ResponseMessage.UNKNOW_ERROR : exception.getResponseMessage();
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), catalystResponseMessage.getMessage(),
                        com.test.exception.response.ResponseStatus.ERROR.getStatus());
        error.setData(catalystResponseMessage.name());
        return error;
    }

    @ExceptionHandler(ReachedMaxLimit.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleMaxLimitError(final ReachedMaxLimit exception) {
        ResponseMessage catalystResponseMessage = exception.getCatalystResponseMessage() == null
                        ? ResponseMessage.UNKNOW_ERROR : exception.getCatalystResponseMessage();
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), catalystResponseMessage.getMessage(),
                        com.test.exception.response.ResponseStatus.ERROR.getStatus());
        error.setData(catalystResponseMessage.name());
        return error;
    }

    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse handleAlreadyExistExceptionError(final AlreadyExistException exception) {
        ResponseMessage catalystResponseMessage = exception.getCatalystResponseMessage() == null
                        ? ResponseMessage.UNKNOW_ERROR : exception.getCatalystResponseMessage();
        ErrorResponse error = new ErrorResponse(HttpStatus.CONFLICT.value(), catalystResponseMessage.getMessage(),
                        com.test.exception.response.ResponseStatus.ERROR.getStatus());
        error.setData(catalystResponseMessage.name());
        return error;
    }
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleBadRequestExceptionError(final BadRequestException exception) {
        ResponseMessage catalystResponseMessage = exception.getCatalystResponseMessage() == null
                        ? ResponseMessage.UNKNOW_ERROR : exception.getCatalystResponseMessage();
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), catalystResponseMessage.getMessage(),
                        com.test.exception.response.ResponseStatus.ERROR.getStatus());
        error.setData(catalystResponseMessage.name());
        return error;
    }
}

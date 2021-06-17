package com.test.exception.response;

public enum ResponseMessage {

    OK("OK"), 
    CONNECTION_TIMEDOUT("0XCNTOUT"), 
    ACCESS_DENIED("0XACESDD"), 
    NO_PRIVILEGE("0XNOPVGE"),
    ID_NOT_FOUND("0XASNOFD"),
    SLOT_TIME_NOT_AVAILABLE("SLOT TIME NOT AVAILABLE"),
    UNKNOW_ERROR("0XUNERROR"),
    VACCINE_CENTER_IN_VALID("Vaccine Center is Invalid"),
    INVALID_DATE("Please choose date within 90days"),
    REACHED_MAX_BOOKING_SLOT_LIMIT("Reached Max booking slot"),
    REACHED_MAX_USER_SLOT_LIMIT("Reached Max Users for timeslot.Please try some other slot"),
    REACHED_MAX_FIRST_DOSE_SLOT_LIMIT("Reached Max First Dose Limit for timeslot.Please try again for some other slot"),
    REACHED_MAX_SECOND_DOSE_SLOT_LIMIT("Reached Max First Dose Limit for timeslot.Please try again for some other slot"),
    TIME_DIFF_LESS("Please book next dose after 15 days"),
    AADHAR_ALREADY_EXISTS("Aadhar Number Already Exist"),
    ID_ALREADY_EXISTS("Beneficiary ID Already Exist"),
    INVALID_AGE("Invalid Age ");

    private String message;

    private ResponseMessage(String message) {
	this.message = message;
    }

    public String getMessage() {
	return message;
    }
}

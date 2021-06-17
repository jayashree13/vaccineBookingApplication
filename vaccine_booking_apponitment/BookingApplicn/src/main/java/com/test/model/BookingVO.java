package com.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.time.LocalTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingVO {
    private Integer id;
    private String beneficiary_id;
    private LocalDate bookingDate;
    private LocalTime fromTime;
    private LocalTime toTime;
    private String dosage_type;
    private String vaccineCenter;

    public String getBeneficiary_id() {
	return beneficiary_id;
    }

    public LocalDate getBookingDate() {
	return bookingDate;
    }

    public LocalTime getFromTime() {
	return fromTime;
    }

    public LocalTime getToTime() {
	return toTime;
    }

    public String getDosage_type() {
	return dosage_type;
    }

    public String getVaccineCenter() {
	return vaccineCenter;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    @Override public String toString() {
	return "BookingVO{" + "beneficiary_id='" + beneficiary_id + '\'' + ", bookingDate=" + bookingDate + ", fromTime=" + fromTime + ", toTime=" + toTime + ", dosage_type='" + dosage_type + '\'' + ", vaccineCenter='" + vaccineCenter + '\'' + '}';
    }
}

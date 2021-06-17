package com.test.service;

import com.test.exception.BadRequestException;
import com.test.exception.ReachedMaxLimit;
import com.test.exception.response.ResponseMessage;
import com.test.model.Booking;
import com.test.model.BookingVO;
import com.test.model.VaccineCenterTimeSlots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;
import static java.time.temporal.ChronoUnit.DAYS;

@Service public class SlotAvailablityService {

    @Autowired VaccineService vaccineService;
    @Autowired BookingService bookingService;

    /**
     * To checck booking date is less than 90 days
     *
     * @param bookingDate
     * @return boolean true if date is in range of 90 days else false
     */
    public boolean validSlotBookingDate(LocalDate bookingDate) {
	return (Math.abs(DAYS.between(LocalDate.now(), bookingDate))) < 90;
    }

    /**
     * validate Time Slot Differnece
     * @param newBookingDate
     * @param oldBookedDate
     * @return
     */
    public boolean validateTimeSlotDifference(LocalDate newBookingDate, LocalDate oldBookedDate) {
	return Period.between(oldBookedDate, newBookingDate).getDays() >= 15;
    }

    /**
     * check vaccinated center  with time slots availabitly
     * @param bookingVO
     * @return vaccineCenterTimeSlots
     */
    public VaccineCenterTimeSlots checkAvailablity(BookingVO bookingVO) {
	VaccineCenterTimeSlots vaccineCenterTimeSlots = getVaccineCenterDetailsByCenterNameAndFromTimeANdToTime(
			bookingVO.getVaccineCenter(), bookingVO.getFromTime(), bookingVO.getToTime());
	List<Booking> bookedData = bookingService
			.getBookedListByDateAndVaccineCenterTimeSlots(bookingVO.getBookingDate(),
					vaccineCenterTimeSlots);
	if (bookedData == null || bookedData.isEmpty()) {
	    return vaccineCenterTimeSlots;
	}
	//REached max user count check
	if (bookedData.size() >= vaccineCenterTimeSlots.getUsersCount()) {
	    throw new ReachedMaxLimit(ResponseMessage.REACHED_MAX_USER_SLOT_LIMIT);
	}
	List<Booking> firstDoseCount = bookedData.stream()
			.filter(obj -> obj.getDosageType().equalsIgnoreCase("first_dose")).collect(Collectors.toList());
	List<Booking> secondDoseCount = bookedData.stream()
			.filter(obj -> obj.getDosageType().equalsIgnoreCase("second_dose"))
			.collect(Collectors.toList());
	if (bookingVO.getDosage_type().equalsIgnoreCase("first_dose") && (firstDoseCount
			.size() >= vaccineCenterTimeSlots.getFirstDose())) {
	    throw new ReachedMaxLimit(ResponseMessage.REACHED_MAX_FIRST_DOSE_SLOT_LIMIT);
	} else if (secondDoseCount.size() >= vaccineCenterTimeSlots.getFirstDose()) {
	    throw new ReachedMaxLimit(ResponseMessage.REACHED_MAX_SECOND_DOSE_SLOT_LIMIT);

	}
	return vaccineCenterTimeSlots;
    }

    /**
     * getVaccineCenterDetailsByCenterNameAndFromTimeANdToTime
     * @param centerName
     * @param fromTime
     * @param toTime
     * @return VaccineCenterTimeSlots
     */
    public VaccineCenterTimeSlots getVaccineCenterDetailsByCenterNameAndFromTimeANdToTime(String centerName,
		    LocalTime fromTime, LocalTime toTime) {
	VaccineCenterTimeSlots vaccineCenterTimeSlots = vaccineService
			.findByCenterNameAndFromTimeAndToTime(centerName, fromTime, toTime);
	if (vaccineCenterTimeSlots == null) {
	    throw new BadRequestException(ResponseMessage.SLOT_TIME_NOT_AVAILABLE);
	}
	return vaccineCenterTimeSlots;
    }
}

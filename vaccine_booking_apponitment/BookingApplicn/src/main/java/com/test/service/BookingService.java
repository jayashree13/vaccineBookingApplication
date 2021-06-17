package com.test.service;

import com.test.model.Beneficiary;
import com.test.model.Booking;
import com.test.model.BookingVO;
import com.test.model.VaccineCenterTimeSlots;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    Booking bookSlot(Booking booking,BookingVO bookingVO, Beneficiary beneficiary, VaccineCenterTimeSlots vaccineCenterTimeSlots);
    Booking updateTimeSlot(Integer bookingId,BookingVO bookingVO);
    List<Booking> getBookedListByDateAndVaccineCenterTimeSlots(LocalDate bookedDate,VaccineCenterTimeSlots vaccineCenterTimeSlots);

    void deleteSlot(Integer id);
}

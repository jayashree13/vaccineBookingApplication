package com.test.service;

import com.test.exception.BadRequestException;
import com.test.exception.response.ResponseMessage;
import com.test.model.*;
import com.test.model.BookingVO;
import com.test.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service public class BookingServiceImpl implements BookingService {
    @Autowired BookingRepository bookingRepository;
    @Autowired BeneficiaryServiceImpl beneficiaryService;
    @Autowired SlotAvailablityService slotAvailablityService;

    /**
     * get All booked data
     *
     * @return List of booked data
     */
    public List<Booking> getAllBookingList() {
	return bookingRepository.findAll();
    }

    /**
     * book time slots
     *
     * @param bookingVO
     */
    public Booking bookTimeSlots(BookingVO bookingVO) {
	Booking booking = new Booking();
	booking = bookingValidation(bookingVO, booking);
	System.out.println("booking vo" + booking.toString());
	return bookingRepository.save(booking);
    }

    /**
     * booking vaidation
     *
     * @param bookingVO
     * @param booking
     * @return booking
     */
    private Booking bookingValidation(BookingVO bookingVO, Booking booking) {
	Beneficiary beneficiary = beneficiaryService.getBeneficiaryById(bookingVO.getBeneficiary_id());
	if (beneficiary == null)
	    throw new BadRequestException(ResponseMessage.ID_NOT_FOUND);
	//check booking date is less than 90days
	if (!slotAvailablityService.validSlotBookingDate(bookingVO.getBookingDate()))
	    throw new BadRequestException(ResponseMessage.INVALID_DATE);
	//Validate max-booking slot
	List<Booking> alreadyBookedSlots = bookingRepository.findByBeneficiary(beneficiary);
	if (alreadyBookedSlots != null && alreadyBookedSlots.size() == 2) {
	    throw new BadRequestException(ResponseMessage.REACHED_MAX_BOOKING_SLOT_LIMIT);
	} else if (alreadyBookedSlots != null && alreadyBookedSlots.size() == 1) {
	    //Validate time diff between two doses for new creation
	    if (booking.getId() == null && !slotAvailablityService.validateTimeSlotDifference(bookingVO.getBookingDate(),
			    alreadyBookedSlots.get(0).getBookedDate())) {
		throw new BadRequestException(ResponseMessage.TIME_DIFF_LESS);
	    }else{
	        bookingVO.setId(booking.getId());
	    }
	}
	//check Availability
	VaccineCenterTimeSlots vaccineCenterTimeSlots = slotAvailablityService.checkAvailablity(bookingVO);
	return bookSlot(booking, bookingVO, beneficiary, vaccineCenterTimeSlots);
    }

    /**
     * List of booking with bookedDate and vaccinatedCenterTimeSlots
     *
     * @param bookedDate
     * @param vaccineCenterTimeSlots
     * @return list of booking
     */
    @Override public List<Booking> getBookedListByDateAndVaccineCenterTimeSlots(LocalDate bookedDate,
		    VaccineCenterTimeSlots vaccineCenterTimeSlots) {
	return bookingRepository.findByBookedDateAndVaccineCenterTimeSlots(bookedDate, vaccineCenterTimeSlots);

    }

    /**
     * book slot
     *
     * @param booking
     * @param bookingVO
     * @param beneficiary
     * @param vaccineCenterTimeSlots
     * @return book creation Obj
     */
    @Override public Booking bookSlot(Booking booking, BookingVO bookingVO, Beneficiary beneficiary,
		    VaccineCenterTimeSlots vaccineCenterTimeSlots) {
	booking.setBeneficiary(beneficiary);
	booking.setVaccineCenterTimeSlots(vaccineCenterTimeSlots);
	booking.setBookedDate(bookingVO.getBookingDate());
	booking.setDosageType(bookingVO.getDosage_type());
	booking.setStatus(Status.Active);
	return booking;
    }

    /**
     * re-schedule time slot
     *
     * @param bookingId
     * @param bookingVO
     * @return
     */
    @Override public Booking updateTimeSlot(Integer bookingId, BookingVO bookingVO) {
	Booking bookingObj = null;
	Optional<Booking> booking = bookingRepository.findById(bookingId);
	if (booking.isPresent()) {
	    bookingObj = booking.get();
	} else {
	    throw new BadRequestException(ResponseMessage.ID_NOT_FOUND);
	}
	bookingObj = bookingValidation(bookingVO, bookingObj);
	return bookingRepository.save(bookingObj);
    }

    /**
     * delete slot
     *
     * @param id
     */
    @Override public void deleteSlot(Integer id) {
	Optional<Booking> booking = bookingRepository.findById(id);
	if (booking.isPresent()) {
	    bookingRepository.delete(booking.get());
	} else {
	    throw new BadRequestException(ResponseMessage.ID_NOT_FOUND);
	}
    }
}

package com.test.controller;

import com.test.exception.response.SuccessResponse;
import com.test.model.Booking;
import com.test.model.BookingVO;
import com.test.service.BookingServiceImpl;
import com.test.service.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController @RequestMapping({ "/book" }) public class BookingController {

    @Autowired BookingServiceImpl bookingService;

    @GetMapping(path = "/version") public String getVersion() {
	return "0.1";
    }

    /**
     * get booked list
     *
     * @return
     */
    @GetMapping(path = "/list/all") public ResponseEntity<?> getBookedList() {
	return new ResponseEntity<>(bookingService.getAllBookingList(), CREATED);

    }

    /**
     * add new booking
     *
     * @param booking
     * @return status (success or failure)
     */
    @PostMapping(path = "/create", consumes = { "application/json" }) public SuccessResponse bookTimeSlot(
		    @RequestBody BookingVO bookingVO) {
	return new SuccessResponse(HttpStatus.OK.value(),
			"Successfully Booked Id:" + bookingService.bookTimeSlots(bookingVO).getId(), Constants.SUCCESS,
			Constants.SUCCESS);
    }

    /**
     * udpdate existing time slot
     * @param id
     * @param bookingVO
     * @return response
     */
    @PutMapping(path = "/update/{id}", consumes = { "application/json" }) public SuccessResponse updateTimeSlot(
		    @PathVariable("id") Integer id, @RequestBody BookingVO bookingVO) {
	bookingService.updateTimeSlot(id, bookingVO);
	return new SuccessResponse(HttpStatus.OK.value(), "Successfully Booked", Constants.SUCCESS, Constants.SUCCESS);
    }

    /**
     * cancel Slot
     * @param id
     * @return response
     */
    @DeleteMapping(path = "/delete/{id}") public SuccessResponse deleteSlot(@PathVariable("id") Integer id) {
	bookingService.deleteSlot(id);
	return new SuccessResponse(HttpStatus.OK.value(), "Cancelled Appointment", Constants.SUCCESS,
			Constants.SUCCESS);
    }
}

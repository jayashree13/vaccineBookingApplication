package com.test.repositories;

import com.test.model.Beneficiary;
import com.test.model.Booking;
import com.test.model.VaccineCenterTimeSlots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

    List<Booking> findByBeneficiary(Beneficiary beneficiary);
    List<Booking> findByBookedDateAndVaccineCenterTimeSlots(LocalDate bookedDate, VaccineCenterTimeSlots vaccineCenterTimeSlots);
}

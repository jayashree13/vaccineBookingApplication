package com.test.repositories;

import com.test.model.Status;
import com.test.model.VaccineCenter;
import com.test.model.VaccineCenterTimeSlots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;

@Repository
public interface VaccineCenterTimeSlotsRepository extends JpaRepository<VaccineCenterTimeSlots,Integer> {

    VaccineCenterTimeSlots findByVaccineCenterAndFromTimeAndToTimeAndStatus(VaccineCenter name, LocalTime fromtime, LocalTime totime,
                    Status status);
}

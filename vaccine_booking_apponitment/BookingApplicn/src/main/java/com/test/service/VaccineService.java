package com.test.service;

import com.test.exception.BadRequestException;
import com.test.exception.response.ResponseMessage;
import com.test.model.Status;
import com.test.model.VaccineCenter;
import com.test.model.VaccineCenterTimeSlots;
import com.test.repositories.VaccineCenterRepository;
import com.test.repositories.VaccineCenterTimeSlotsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service public class VaccineService {
    @Autowired VaccineCenterRepository vaccineCenterRepository;
    @Autowired VaccineCenterTimeSlotsRepository vaccineCenterTimeSlotsRepository;

    /**
     * getVaccineCenterByName
     *
     * @param name
     * @return VaccineCenter
     */
    public VaccineCenter getVaccineCenterByName(String name) {
	VaccineCenter vaccineCenter = vaccineCenterRepository.findByNameAndStatus(name, Status.Active);
	if (vaccineCenter == null)
	    throw new BadRequestException(ResponseMessage.VACCINE_CENTER_IN_VALID);
	return vaccineCenter;
    }

    /**
     * findByCenterNameAndFromTimeAndToTime
     *
     * @param centerName
     * @param fromTime
     * @param toTime
     * @return VaccineCenterTimeSlots
     */
    public VaccineCenterTimeSlots findByCenterNameAndFromTimeAndToTime(String centerName, LocalTime fromTime,
		    LocalTime toTime) {
	return vaccineCenterTimeSlotsRepository
			.findByVaccineCenterAndFromTimeAndToTimeAndStatus(getVaccineCenterByName(centerName), fromTime,
					toTime, Status.Active);
    }
}

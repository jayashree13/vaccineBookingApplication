package com.test.service;

import com.test.exception.AlreadyExistException;
import com.test.exception.InvalidAgeException;
import com.test.exception.response.ResponseMessage;
import com.test.model.Beneficiary;
import com.test.repositories.BeneficiaryRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

@Service public class BeneficiaryServiceImpl {
    @Autowired BeneficiaryRepository beneficiaryRepository;

    /**
     * get list of benerficiaries
     *
     * @return list of benerficiaries
     */
    public List<Beneficiary> getAllBeneficiaries() {
	return beneficiaryRepository.findAll();
    }

    /**
     * add new account
     *
     * @param beneficiary
     * @return system-generatedId
     */
    public String addNewBeneficiary(Beneficiary beneficiary) {
	Beneficiary beneficiaryValue = beneficiaryRepository.findByAadharNo(beneficiary.getAadharNo()).orElse(null);
	if (beneficiaryValue != null) {
	    throw new AlreadyExistException(ResponseMessage.AADHAR_ALREADY_EXISTS);
	}
	if (calculateAge(beneficiary.getDateOfBirth(), LocalDate.now()) < 45) {
	    throw new InvalidAgeException(ResponseMessage.INVALID_AGE);
	}
	//validations for phone number
	System.out.println("sys id");
	String id = generateId();
	System.out.println("sys id" + id);
	beneficiary.setId(id);
	beneficiaryRepository.save(beneficiary);
	return beneficiary.getId();
    }

    public String getBeneficiaryId(String id) {
	Beneficiary beneficiary = getBeneficiaryById(id);
	return (beneficiary != null) ? beneficiary.getId() : null;
    }

    public Beneficiary getBeneficiaryById(String id) {
	return beneficiaryRepository.findById(id).orElse(null);
    }

    /**
     * generate random Id (SYS-"random cahra)+time
     * @return
     */
    private String generateId() {
	StringBuilder stringBuilder = new StringBuilder("SYS_");
	stringBuilder.append(RandomStringUtils.randomAlphanumeric(6) + new Date().getTime());
	return stringBuilder.toString();
    }

    /**
     * calculate Age
     *
     * @param birthDate
     * @param currentDate
     * @return age
     */
    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
	if ((birthDate != null) && (currentDate != null)) {
	    return Period.between(birthDate, currentDate).getYears();
	} else {
	    return 0;
	}
    }
}

package com.test.controller;

import com.test.exception.response.SuccessResponse;
import com.test.model.Beneficiary;
import com.test.service.BeneficiaryServiceImpl;
import com.test.service.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping({"/beneficiary"})
public class RegisterController {
    @Autowired BeneficiaryServiceImpl beneficiaryService;

    @GetMapping(path = "/version") public String getVersion() {
	return "0.1";
    }

    @GetMapping(path = "/list/all") public ResponseEntity<?> getAllUsers() {
	return new ResponseEntity<>(beneficiaryService.getAllBeneficiaries(), CREATED);

    }

    @PostMapping(path = "/register", consumes = { "application/json" })
    public SuccessResponse registerUser( @RequestBody Beneficiary beneficiary) {
	System.out.println("booking" + beneficiary.toString());
	return new SuccessResponse(HttpStatus.OK.value(),"Successfully created user with Id :"+beneficiaryService.addNewBeneficiary(beneficiary),
			Constants.SUCCESS);
    }
}

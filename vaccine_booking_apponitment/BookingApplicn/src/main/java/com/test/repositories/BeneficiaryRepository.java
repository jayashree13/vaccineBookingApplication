package com.test.repositories;

import com.test.model.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary,String> {

    Optional<Beneficiary> findByAadharNo(String Aadhar);
}

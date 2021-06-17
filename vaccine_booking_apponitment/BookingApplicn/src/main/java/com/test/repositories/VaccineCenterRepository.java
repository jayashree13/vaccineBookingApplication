package com.test.repositories;

import com.test.model.Status;
import com.test.model.VaccineCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineCenterRepository extends JpaRepository<VaccineCenter,Integer> {
    VaccineCenter findByNameAndStatus(String name, Status status);
}

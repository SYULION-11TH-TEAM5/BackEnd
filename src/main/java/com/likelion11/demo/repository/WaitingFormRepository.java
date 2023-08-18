package com.likelion11.demo.repository;

import com.likelion11.demo.entity.Hospital;
import com.likelion11.demo.entity.WaitingForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaitingFormRepository extends JpaRepository<WaitingForm, Long> {
    Long countByHospitalAndIsCompletedFalse(Hospital hospital);
}
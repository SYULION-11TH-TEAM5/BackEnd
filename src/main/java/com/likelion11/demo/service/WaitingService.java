package com.likelion11.demo.service;

import com.likelion11.demo.entity.Doctor;
import com.likelion11.demo.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WaitingService {
    private final DoctorRepository doctorRepository;
    public Long WaitingCount() {
        return null;
    }

    public Long getUser() {
        return null;
    }
}

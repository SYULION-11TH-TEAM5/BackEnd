package com.likelion11.demo.service;

import com.likelion11.demo.dto.WaitingDto;
import com.likelion11.demo.entity.Hospital;
import com.likelion11.demo.exception.HospitalNotFoundException;
import com.likelion11.demo.repository.HospitalRepository;
import com.likelion11.demo.repository.WaitingFormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WaitingService {
    private final WaitingFormRepository waitingFormRepository;
    private final HospitalRepository hospitalRepository;

    public WaitingDto.ListRes getWaitingList(Long id) {
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new HospitalNotFoundException(id));

        // 각 병원 정보를 활용하여 WaitingDto.ListRes 객체 생성
        WaitingDto.ListRes waiting = WaitingDto.ListRes.builder()
                .area("공릉동")
                .name(hospital.getName())
                .workingDay(hospital.getWorkingDay())
                .businessHours(hospital.getBusinessHours())
                .count(getWaitingCount(id)) //대기 인원 수
                .build();

        return waiting;
    }

    private Long getWaitingCount(Long id) {
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new HospitalNotFoundException(id));

        return waitingFormRepository.countByHospitalAndIsCompletedFalse(hospital);
    }
}
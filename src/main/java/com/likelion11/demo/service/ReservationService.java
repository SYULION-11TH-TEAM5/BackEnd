package com.likelion11.demo.service;

import com.likelion11.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // 비즈니스 로직 구현
    // 예약 생성, 조회, 수정, 삭제 등의 메서드
}

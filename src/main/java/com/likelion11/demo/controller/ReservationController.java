package com.likelion11.demo.controller;

import com.likelion11.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public String listReservations(Model model) {
        // 예약 목록 조회 등의 코드
        return "reservation/list";
    }

    // 다른 컨트롤러 메서드들
}

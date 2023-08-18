package com.likelion11.demo.controller;

import com.likelion11.demo.entity.Reservation;
import com.likelion11.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // 예약 목록 조회 페이지로 이동하고 모든 예약 정보를 화면에 표시
    @GetMapping
    public String listReservations(Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations", reservations);
        return "reservation/list"; // templates/reservation/list.html로 이동
    }

    // 특정 ID의 예약 정보를 조회하고 상세 정보를 화면에 표시
    @GetMapping("/{id}")
    public String viewReservation(@PathVariable Long id, Model model) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        if (reservation.isPresent()) {
            model.addAttribute("reservation", reservation.get());
            return "reservation/view"; // templates/reservation/view.html로 이동
        } else {
            return "redirect:/reservations"; // 목록 페이지로 리다이렉트
        }
    }

    // 새로운 예약 생성 폼을 화면에 표시
    @GetMapping("/new")
    public String newReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservation/form"; // templates/reservation/form.html로 이동
    }

    // 예약 정보를 생성하고 목록 페이지로 리다이렉트
    @PostMapping
    public String createReservation(@ModelAttribute Reservation reservation) {
        reservationService.createReservation(reservation);
        return "redirect:/reservations";
    }

    // 특정 ID의 예약 정보 수정 폼을 화면에 표시
    @GetMapping("/{id}/edit")
    public String editReservationForm(@PathVariable Long id, Model model) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        if (reservation.isPresent()) {
            model.addAttribute("reservation", reservation.get());
            return "reservation/form"; // templates/reservation/form.html로 이동
        } else {
            return "redirect:/reservations"; // 목록 페이지로 리다이렉트
        }
    }

    // 예약 정보를 수정하고 목록 페이지로 리다이렉트
    @PostMapping("/{id}/edit")
    public String updateReservation(@PathVariable Long id, @ModelAttribute Reservation reservation) {
        reservationService.updateReservation(id, reservation);
        return "redirect:/reservations";
    }

    // 특정 ID의 예약 정보를 삭제하고 목록 페이지로 리다이렉트
    @GetMapping("/{id}/delete")
    public String deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return "redirect:/reservations";
    }
}

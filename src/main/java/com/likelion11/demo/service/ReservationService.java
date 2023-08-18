package com.likelion11.demo.service;

import com.likelion11.demo.entity.Reservation;
import com.likelion11.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // 예약 생성
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // 모든 예약 조회
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // 특정 ID로 예약 조회
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    // 예약 수정
    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Optional<Reservation> existingReservation = reservationRepository.findById(id);
        if (existingReservation.isPresent()) {
            Reservation reservationToUpdate = existingReservation.get();
            reservationToUpdate.setPatientName(updatedReservation.getPatientName());
            reservationToUpdate.setDateTime(updatedReservation.getDateTime());
            return reservationRepository.save(reservationToUpdate);
        }
        return null; // 또는 예외 처리
    }

    // 예약 삭제
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

}

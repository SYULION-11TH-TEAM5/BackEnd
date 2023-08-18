package com.likelion11.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity  // JPA 엔티티 클래스임을 선언
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ID 필드를 자동으로 생성하도록 설정
    private Long id;  // 예약 식별자

    private String patientName;  // 환자 이름
    private LocalDateTime dateTime;  // 진료 예약 일시

    // Getters and setters

    // 아래는 Getter와 Setter 메서드들
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}

package com.likelion11.demo.entity;

import jakarta.persistence.*;
import lombok.*;

// 대기 신청서

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WaitingForm {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @Column(nullable = false)
    private String symptom;       //증상

    @Column(nullable = false)
    private String onset;       //발병일

    @Column(nullable = false)
    private Boolean isCompleted;
}

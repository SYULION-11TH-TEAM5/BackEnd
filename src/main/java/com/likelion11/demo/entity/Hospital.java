package com.likelion11.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hospital {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;    //병원명

    @Column(nullable = false)
    private String type;    //병원 과 종류

    @Column(nullable = false)
    private String telephone;

    @OneToMany(mappedBy = "hospital")
    private final List<WaitingList> waitingLists = new ArrayList<>();

    @OneToMany(mappedBy = "hospital")
    private final List<WaitingForm> waitingForms = new ArrayList<>();

    @OneToMany(mappedBy = "hospital")
    private final List<Doctor> doctors = new ArrayList<>();

}

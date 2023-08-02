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

    private String name;    //병원명

    private String type;    //병원 과 종류

    @OneToMany(mappedBy = "hospital")
    private final List<WaitingList> waitingLists = new ArrayList<>();

    @OneToMany(mappedBy = "hospital")
    private final List<WaitingForm> waitingForms = new ArrayList<>();

    public Hospital(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

package com.likelion11.demo.exception;

import lombok.Getter;

import java.security.Principal;

@Getter
public class HospitalNotFoundException extends RuntimeException{
    private final Object userId;
    private Principal principal;
    public HospitalNotFoundException(Object userId) {
        this.userId = userId;
    }

    public HospitalNotFoundException(Object userId, Principal principal) {
        this.userId = userId;
        this.principal = principal;
    }
}

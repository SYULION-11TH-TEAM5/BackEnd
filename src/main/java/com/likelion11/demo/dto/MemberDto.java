package com.likelion11.demo.dto;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

@Data
@DynamicInsert
public class memberDto {
    private Long id;
    private String username;
    private String password;
    private String email;

    private String name;
}

package com.likelion11.demo.dto;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

@Data
@DynamicInsert
public class loginMember {
    public String email;
    public String password;

}

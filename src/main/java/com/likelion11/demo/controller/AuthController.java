package com.likelion11.demo.controller;

import com.likelion11.demo.dto.ResultCode;
import com.likelion11.demo.dto.loginMember;
import com.likelion11.demo.entity.Member;
import com.likelion11.demo.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

@Slf4j
@RequestMapping("/api/auth")
@AllArgsConstructor
@RestController
public class AuthController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/signup")
    public ResultCode signup(@ModelAttribute  Member member){
        return memberService.registerMember(member);
    }

    @PostMapping("/login")
    public ResultCode login(@ModelAttribute loginMember user) {
        return memberService.loginMember(user);// 로그인 폼 뷰 페이지
    }
}

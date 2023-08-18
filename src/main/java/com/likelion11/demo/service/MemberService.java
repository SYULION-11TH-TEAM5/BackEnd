package com.likelion11.demo.service;

import com.likelion11.demo.dto.ResultCode;
import com.likelion11.demo.dto.loginMember;
import com.likelion11.demo.dto.memberDto;
import com.likelion11.demo.entity.Member;
import com.likelion11.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service // 이 부분 추가
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResultCode registerMember(Member member) {
        if(member ==null) {
            return new ResultCode(-99, "유효하지 않은 입력입니다.");
        } else {
            String encodedPassword = passwordEncoder.encode(member.getPassword());
            member.setPassword(encodedPassword);
            Member user = memberRepository.save(member);
            return new ResultCode(0, "새 아이디를 생성하였습니다.", user.getId());
        }}

    public ResultCode loginMember(loginMember user) {
        Member userInfo = memberRepository.findByEmail(user.getEmail());
        if (passwordEncoder.matches(user.getPassword(), userInfo.getPassword())){
            memberDto member = new memberDto();
            member.setId(userInfo.getId());
            member.setEmail(userInfo.getEmail());
            member.setName(userInfo.getName());
            member.setUsername(userInfo.getUsername());
            return new ResultCode(0, "로그인 완료", member);
        } else {
            return new ResultCode(-99, "유효하지 않은 입력입니다.");
        }
    }
}


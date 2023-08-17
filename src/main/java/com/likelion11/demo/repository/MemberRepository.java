package com.likelion11.demo.repository;

import com.likelion11.demo.dto.memberDto;
import com.likelion11.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String username);

    Member findByEmail(String email);

    //void insertNewUser()
}

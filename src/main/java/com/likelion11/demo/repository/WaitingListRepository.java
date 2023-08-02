package com.likelion11.demo.repository;

import com.likelion11.demo.entity.WaitingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaitingListRepository extends JpaRepository<WaitingList, Long> {
}

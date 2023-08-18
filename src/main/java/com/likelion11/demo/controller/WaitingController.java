package com.likelion11.demo.controller;

import com.likelion11.demo.dto.WaitingDto;
import com.likelion11.demo.service.WaitingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class WaitingController {
    private final WaitingService waitingService;

    @GetMapping("/waiting/{id}")
    public ResponseEntity<WaitingDto.ListRes> getWaitingList(@PathVariable Long id) {
        return ResponseEntity.ok(waitingService.getWaitingList(id));
    }
}
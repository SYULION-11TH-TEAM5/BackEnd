package com.likelion11.demo.dto;

import lombok.*;

public class WaitingDto {
    @Getter @Setter @ToString
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListRes {
        private String area;
        private String name;
        private String workingDay;
        private String businessHours;
        private Long count;
    }
}

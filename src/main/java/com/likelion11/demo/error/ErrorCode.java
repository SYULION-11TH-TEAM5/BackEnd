package com.likelion11.demo.error;

import lombok.Getter;

@Getter
public enum ErrorCode {
    USER_NOT_FOUND("USER_NOT_FOUND", "해당 유저를 찾을 수 없습니다.", 400),
    INPUT_VALUE_INVALID("INPUT_VALUE_INVALID", "데이터 형식이 맞지 않습니다.", 400),
    ;

    private final String code;
    private final String message;
    private final Integer status;

    ErrorCode(String code, String message, Integer status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}

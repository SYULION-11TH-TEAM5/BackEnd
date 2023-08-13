package com.likelion11.demo.error;

import com.likelion11.demo.exception.UserNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.likelion11.demo.error.ErrorBuildFactory.buildError;

@Slf4j
@RestControllerAdvice
public class ErrorHandlingController {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleEntityNotFoundException() {
        log.error("해당 엔티티를 찾을 수 없습니다.");
        return buildError(ErrorCode.USER_NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleMemberNotFoundException() {
        log.error("프론트로부터 잘못된 멤버 id가 전달되었습니다.");
        return buildError(ErrorCode.USER_NOT_FOUND);
    }
}

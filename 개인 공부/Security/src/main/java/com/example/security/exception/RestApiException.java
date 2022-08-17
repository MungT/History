package com.example.security.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RestApiException {
    private String errorMessage;
    private HttpStatus httpStatus;
    // 오류 발생 시 errorMessage와 httpStatus 출력
}
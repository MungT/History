package com.example.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 글로벌 예외처리 기능 (Filter에서의 예외는 기능하지 않는다.)
public class RestApiExceptionHandler {

    @ExceptionHandler({RuntimeException.class, UsernameNotFoundException.class})
    // RuntimeException, UsernameNotFoundException 오류만 처리 해 준다.
    public ResponseEntity<Object> handleApiRequestException(Exception ex) {  // ex = 메세지 문구
        // 오류 발생 문구 작성
        RestApiException restApiException = new RestApiException();
        restApiException.setHttpStatus(HttpStatus.BAD_REQUEST); // Response body에 BAD_REQUEST문구 출력
        restApiException.setErrorMessage(ex.getMessage()); // 메세지 출력

        return new ResponseEntity(
                restApiException,
                HttpStatus.BAD_REQUEST // 404 BAD_REQUEST Status 지정
        );
    }
}
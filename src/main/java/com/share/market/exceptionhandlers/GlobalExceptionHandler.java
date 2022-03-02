package com.share.market.exceptionhandlers;

import com.share.market.dtos.ResponseDto;
import com.share.market.exception.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ResponseDto<String>> handleValidationException(ValidationException e) {
        return ResponseEntity
                .badRequest()
                .body(new ResponseDto<>("Validation Error", -1, e.getMessage()));
    }
}

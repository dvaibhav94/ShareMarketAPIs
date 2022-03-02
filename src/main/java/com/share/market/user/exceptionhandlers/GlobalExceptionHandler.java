package com.share.market.user.exceptionhandlers;

import com.share.market.user.dtos.ValidationResponse;
import com.share.market.user.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ValidationResponse> handleValidationException(UserNotFoundException e) {
        return ResponseEntity.badRequest().body(new ValidationResponse(e.getMessage()));
    }
}

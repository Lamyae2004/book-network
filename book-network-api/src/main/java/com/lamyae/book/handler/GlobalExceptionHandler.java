package com.lamyae.book.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import static com.lamyae.book.handler.BusinessErrorCode.BAD_CREDENTIELS;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(LockedException.class)
    public ResponseEntity<ExceptionResponse> handleException(LockedException exception){
       return ResponseEntity
               .status(HttpStatus.UNAUTHORIZED)
               .body(ExceptionResponse.builder().
               businessErrorCode(BusinessErrorCode.ACCOUNT_LOCKED.getCode())
                       .businessErrorDescription(BusinessErrorCode.ACCOUNT_LOCKED.getDescription())
                       .error(exception.getMessage()).build());
    }


    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<ExceptionResponse> handleException(DisabledException exception){
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ExceptionResponse.builder().
                        businessErrorCode(BusinessErrorCode.ACCOUNT_DISABLED.getCode())
                        .businessErrorDescription(BusinessErrorCode.ACCOUNT_DISABLED.getDescription())
                        .error(exception.getMessage()).build());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionResponse> handleException(BadCredentialsException exception){
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ExceptionResponse.builder().
                        businessErrorCode(BAD_CREDENTIELS.getCode())
                        .businessErrorDescription(BAD_CREDENTIELS.getDescription())
                        .error(BAD_CREDENTIELS.getDescription()).build());
    }
}

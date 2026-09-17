package com.lamyae.book.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum BusinessErrorCode {
    NO_CODE(0,HttpStatus.NOT_IMPLEMENTED,"No code"),
    ACCOUNT_LOCKED(302,HttpStatus.FORBIDDEN,"User account is locked"),
    INCORRECT_CURRENT_PASSWORD(300,HttpStatus.BAD_REQUEST,"User password is incorrect"),
    NEW_PASSWORD_DOES_NOT_MATCH(301,HttpStatus.BAD_REQUEST,"User password DOES not match"),
    ACCOUNT_DISABLED(303,HttpStatus.FORBIDDEN,"User account is Disabled"),
    BAD_CREDENTIELS(304,HttpStatus.FORBIDDEN,"LOGIN/password incorrect"),


    ;

    @Getter
    private final int code ;
    @Getter
    private final String description;
    @Getter
    private final HttpStatus httpStatus ;

    BusinessErrorCode(int code, HttpStatus httpStatus ,String description) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}

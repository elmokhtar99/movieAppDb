package com.transperfect.movieapplicationdb.controllers;

import com.transperfect.movieapplicationdb.dtos.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.transperfect.movieapplicationdb.Constant.ERROR_SYSTEM;
@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handleApiException(Exception e){
        return new ResponseEntity<>(new BaseResponse(false,ERROR_SYSTEM), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


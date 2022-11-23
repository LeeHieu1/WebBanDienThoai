package com.nhom13.controller.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import com.nhom13.controller.exception.CommonRuntimeException;
import com.nhom13.payload.response.BaseResponse;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(CommonRuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse ssuserInfoExceptionHandler(CommonRuntimeException ex) {
        return new BaseResponse(false, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse ExceptionHandler(Exception ex) {
        return new BaseResponse(false, ex.getMessage());
    }

}

package com.cat.zsy.mvc.controller;

import com.cat.zsy.mvc.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

//    @ExceptionHandler(CustomException.class)
//    @ResponseBody
//    public Result<String> handWebException(CustomException e) {
//        logger.error(e.getMessage(), e);
//        return Result.of(e.getCode(), e.getMessage(), null);
//    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result<String> handRuntimeException(Exception e) {
        logger.error(e.getMessage(), e);
        return Result.from(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Result<String> handleThrowable(Throwable throwable) {
        logger.error(throwable.getMessage(), throwable);
        return Result.from(HttpStatus.INTERNAL_SERVER_ERROR, throwable.getMessage());
    }

}
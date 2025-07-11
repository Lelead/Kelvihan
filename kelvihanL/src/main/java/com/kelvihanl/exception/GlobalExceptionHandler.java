package com.kelvihanl.exception;

import com.kelvihanl.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice("com.kelvihanl.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody //返回json串
    public Result error(Exception e){
        e.printStackTrace();
        return Result.error();
    }

    @ExceptionHandler(CustomerException.class)
    @ResponseBody //返回json串
    public Result error(CustomerException e){
        return Result.error(e.getCode(), e.getMsg());
    }
}

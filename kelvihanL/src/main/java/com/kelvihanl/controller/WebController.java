package com.kelvihanl.controller;


import com.kelvihanl.common.Result;
import com.kelvihanl.exception.CustomerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/hello")
    public Result hello() {
        return Result.success("hello");
    }

    @GetMapping("/count")
    public Result count() {
        return Result.success(10);
    }

    @GetMapping("/error1")
    public Result error() {
        throw new CustomerException(10, "错误！禁止访问");
    }
}

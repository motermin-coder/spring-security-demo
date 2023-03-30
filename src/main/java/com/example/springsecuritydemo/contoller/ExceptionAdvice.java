package com.example.springsecuritydemo.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Auth tom
 * @Date 2023-03-30 11:33:47
 */
@ControllerAdvice(
        basePackages = "com.example.springsecuritydemo.contoller"
        ,annotations = Controller.class)
public class ExceptionAdvice {


    @ExceptionHandler(value = Exception.class)
    public String hello(Exception e){
        System.out.println("e = " + e);
        return "exception";
    }
}

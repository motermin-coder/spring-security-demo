package com.example.springsecuritydemo.component;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Auth tom
 * @Date 2023-03-30 11:24:47
 */
@Component
public class CheckUserAuthorizes {

    @Resource
    private TokenComponent tokenComponent;


    public String getUserInfo(String token){

        Claims claims = tokenComponent.parseToken(token);
        System.out.println("claims = " + claims);
        return null;
    }
}

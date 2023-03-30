package com.example.springsecuritydemo.component;

import org.springframework.stereotype.Component;

/**
 * @Auth tom
 * @Date 2023-03-29 22:35:04
 */
@Component("ss")
public class PermissionService {


    public boolean isAdmin(String role){
        return "ADMIN".equals(role);
    }
}

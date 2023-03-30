package com.example.springsecuritydemo.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auth tom
 * @Date 2023-03-29 22:06:20
 */
@Data
public class LoginUser implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private List<Role> authorities = new ArrayList<>();
    private Integer loginTime;
    private String loginIp;
    private String token;
}

package com.example.springsecuritydemo.mapper;

import com.example.springsecuritydemo.pojo.User;

/**
 * @Auth tom
 * @Date 2023-03-28 14:24:11
 */
public interface UserMapper {

    User findUserByUserName(String username);
}

package com.example.springsecuritydemo.service.impl;

import com.example.springsecuritydemo.mapper.RoleMapper;
import com.example.springsecuritydemo.mapper.UserMapper;
import com.example.springsecuritydemo.pojo.Role;
import com.example.springsecuritydemo.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auth tom
 * @Date 2023-03-29 15:48:27
 */
@Component
public class SecurityUserServiceImpl implements UserDetailsService {


    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userByUserName = userMapper.findUserByUserName(username);
        if (userByUserName == null){
            return new User();
        }
        List<Role> roleByUserId = roleMapper.findRoleByUserId(userByUserName.getId());
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : roleByUserId) {
            grantedAuthorities.add((GrantedAuthority) role::getName);
        }
        userByUserName.setAuthorities(grantedAuthorities);
        return userByUserName;
    }

}

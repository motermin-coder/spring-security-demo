package com.example.springsecuritydemo.component;

import com.example.springsecuritydemo.pojo.LoginUser;
import com.example.springsecuritydemo.pojo.User;
import com.example.springsecuritydemo.util.ValueCheck;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Auth tom
 * @Date 2023-03-29 11:31:43
 */
@Component
public class LoginService {


    @Resource
    private TokenComponent tokenComponent;

    @Resource
    private DaoAuthenticationProvider authenticationProvider;

    @Resource
    private RedisService redisService;

    public String login(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        if (!ValueCheck.isNotNullAndEmpty(username) && !ValueCheck.isNotNullAndEmpty(password)){
            return null;
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        SecurityContext emptyContext = SecurityContextHolder.createEmptyContext();
        emptyContext.setAuthentication(usernamePasswordAuthenticationToken);
        SecurityContextHolder.setContext(emptyContext);
        Authentication authenticate = authenticationProvider.authenticate(usernamePasswordAuthenticationToken);
        if (authenticate == null){
            return null;
        }
        User user1 = (User) authenticate.getPrincipal();
        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(user1,loginUser);
        SecurityContextHolder.clearContext();
        return createToken(loginUser);
    }

    private String createToken(LoginUser loginUser){
        String s = UUID.randomUUID().toString();
        loginUser.setToken(s);
        redisService.saveObject(s,loginUser);
        Map<String,Object> map = new HashMap<>();
        map.put("token",s);
        return tokenComponent.generateToken(map);
    }
}

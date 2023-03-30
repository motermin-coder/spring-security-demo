package com.example.springsecuritydemo.contoller;

import com.example.springsecuritydemo.component.LoginService;
import com.example.springsecuritydemo.pojo.ResultMap;
import com.example.springsecuritydemo.pojo.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Auth tom
 * @Date 2023-03-28 17:29:56
 */
@RestController
public class UserController {

    @Resource
    private LoginService loginService;



    @PostMapping("/login")
    public ResultMap<?> login(@RequestBody User user){
        if (user == null){
            return new ResultMap<>().success(new Date());
        }
        String login = loginService.login(user);
        return new ResultMap<>().success(login);
    }

}

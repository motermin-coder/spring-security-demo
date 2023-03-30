package com.example.springsecuritydemo.contoller;

import com.example.springsecuritydemo.component.PermissionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auth tom
 * @Date 2023-03-28 11:45:02
 */
@RestController
public class WebController {



    @PreAuthorize("@ss.isAdmin('ADMIN')")
    @GetMapping("/test")
    public String test(){
        return "test success";
    }



    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user/info")
    public String info(Authentication authentication){
        Object principal = authentication.getPrincipal();
        return null;
    }


    @GetMapping("/index")
    public String index(){
        return "hello world!";
    }

}

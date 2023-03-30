package com.example.springsecuritydemo.config;

import com.example.springsecuritydemo.component.CheckUserAuthorizes;
import com.example.springsecuritydemo.util.ValueCheck;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auth tom
 * @Date 2023-03-29 22:03:34
 */
@Component
public class JwtTokenRequestFilter extends OncePerRequestFilter {

    @Resource
    private CheckUserAuthorizes authorizes;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if (ValueCheck.isNotNullAndEmpty(authorization)){
            authorization = authorization.replace("Bearer","");
            String userInfo = authorizes.getUserInfo(authorization);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken("tom","123456");
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
        filterChain.doFilter(request,response);
    }
}

//package com.example.springsecuritydemo.filter;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.filter.DelegatingFilterProxy;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import java.io.IOException;
//
///**
// * @Auth tom
// * @Date 2023-03-28 13:00:46
// */
//@Component
//public class MyDelegatingFilterProxy extends DelegatingFilterProxy {
//
//    public MyDelegatingFilterProxy(String targetBeanName, WebApplicationContext wac) {
//        super(targetBeanName, wac);
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        super.doFilter(request, response, filterChain);
//    }
//}

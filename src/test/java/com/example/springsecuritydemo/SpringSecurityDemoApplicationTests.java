package com.example.springsecuritydemo;


import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class SpringSecurityDemoApplicationTests {

    @Test
    public void regexpTest(){
        Pattern compile = Pattern.compile("\\d");
        Matcher matcher = compile.matcher("10");
        long num = 0;
        if (matcher.find()){
            System.out.println("num = " + matcher.find());
        }
    }

    @Test
    void contextLoads() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println("encode = " + encode);
    }

    @Resource
    private RedisTemplate<String,Object> redisTemplate;


    @Test
    void test(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","jerry");
        jsonObject.put("age",20);
        redisTemplate.opsForValue().set("hello",jsonObject,60, TimeUnit.SECONDS);
    }
}

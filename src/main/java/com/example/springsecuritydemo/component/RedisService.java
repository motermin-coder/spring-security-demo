package com.example.springsecuritydemo.component;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Auth tom
 * @Date 2023-03-30 10:36:57
 */
@Component
public class RedisService {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 保存对象
     * @param key
     * @param object
     */
    public void saveObject(String key, Object object){
        if (key == null){
            throw new RuntimeException("key not null");
        }
        redisTemplate.opsForValue().set(key,object);
    }

    /**
     * 保存对象并指定时间
     * @param key
     * @param object
     * @param time
     * @param timeUnit
     */
    public void saveObject(String key, Object object, Integer time, TimeUnit timeUnit){
        if (key == null){
            throw new RuntimeException("key not null");
        }
        redisTemplate.opsForValue().set(key,object,time,timeUnit);
    }
}

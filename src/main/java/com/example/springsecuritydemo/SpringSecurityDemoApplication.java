package com.example.springsecuritydemo;

import com.example.springsecuritydemo.config.ObjectSerializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.springsecuritydemo.mapper"})
public class SpringSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }


    @Bean
    RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> objectObjectRedisTemplate = new RedisTemplate<>();
        objectObjectRedisTemplate.setConnectionFactory(redisConnectionFactory);
        objectObjectRedisTemplate.setKeySerializer(RedisSerializer.string());
        objectObjectRedisTemplate.setHashKeySerializer(RedisSerializer.string());
        objectObjectRedisTemplate.setValueSerializer(new ObjectSerializer());
        objectObjectRedisTemplate.setHashValueSerializer(new ObjectSerializer());
        return objectObjectRedisTemplate;
    }

}

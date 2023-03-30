package com.example.springsecuritydemo.config;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.StandardCharsets;

/**
 * @Auth tom
 * @Date 2023-03-30 10:42:22
 */
public class ObjectSerializer implements RedisSerializer<Object> {

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        return o != null ? JSON.toJSONString(o).getBytes(StandardCharsets.UTF_8) : new byte[0];
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return bytes != null && bytes.length != 0 ? JSON.parseObject(new String(bytes)): new byte[0];
    }
}

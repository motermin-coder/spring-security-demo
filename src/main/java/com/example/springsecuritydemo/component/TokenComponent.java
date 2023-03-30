package com.example.springsecuritydemo.component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auth tom
 * @Date 2023-03-28 18:10:44
 */
@Component
public class TokenComponent {

    @Value("${token.secret}")
    public String secret;

    @Value("${token.expire.time}")
    private String time;

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /**
     * 生产对应的token
     * @param o
     * @return
     */
    public String generateToken(Map<String,Object> o){
        if (time == null || "".equals(time)){
            time = "2";
        }
        Pattern compile = Pattern.compile("\\d");
        Matcher matcher = compile.matcher(time);
        long num = 0;
        if (matcher.find()){
            num = Long.parseLong(time);
        }
        Date date = new Date();
        long time = date.getTime() + num * 3600 * 1000;
        Date date1 = new Date(time);
        return Jwts.builder().setClaims(o).signWith(key).setExpiration(date1).compact();
    }

    /**
     * 解析token
     * @param token
     * @return
     */
    public Claims parseToken(String token){
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
}

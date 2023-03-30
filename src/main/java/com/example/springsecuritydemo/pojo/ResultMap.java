package com.example.springsecuritydemo.pojo;

import lombok.Data;

/**
 * @Auth tom
 * @Date 2023-03-28 17:30:34
 */
@Data
public class ResultMap<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResultMap<T> success(T data){
        this.code = 200;
        this.data = data;
        this.msg = "success";
        return this;
    }

    public ResultMap<T> fail(T data){
        this.code = 500;
        this.data = data;
        this.msg = "fail";
        return this;
    }
}

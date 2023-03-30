package com.example.springsecuritydemo.util;

/**
 * @Auth tom
 * @Date 2023-03-29 11:35:55
 */
public class ValueCheck {

    /**
     * 判断值不为null和空
     * @param param
     * @return
     */
    public static boolean isNotNullAndEmpty(String param){
        return param != null && !"".equals(param);
    }
}

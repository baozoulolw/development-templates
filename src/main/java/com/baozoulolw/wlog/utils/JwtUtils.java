package com.baozoulolw.wlog.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baozoulolw.wlog.entity.User;

import java.util.Calendar;

/**
 * jwt工具类
 *
 * @author Baozoulolw
 * @version 1.0
 * @date 2021-06-09 14:35
 */
public class JwtUtils {


    public static final String TOKEN_HEADER = "Authorization";

    private final static String SIGN = "";

    public static String getToken(User user) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,1);
        String token="";
        token= JWT.create().withAudience(String.valueOf(user.getId()))
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    public String verifyToken(String token){
        return null;
    }



}


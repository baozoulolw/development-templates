package com.baozoulolw.wlog.utils;


import com.auth0.jwt.JWT;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 用户相关工具类
 *
 * @author baozoulolw
 * @version 1.0
 * @date 2022-04-15 15:44
 */
public class UserUtils {

    private static final String HEADER = "Authorization";

    /**
     * 获取当前线程操作的userid;
     * @return
     */
    public static Long getUserId() {

        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String token = request.getHeader(HEADER);
        String userId = JWT.decode(token).getAudience().get(0);
        return Long.valueOf(userId);
    }

    /**
     * 获取当前线程操作的request;
     * @return
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    /**
     * 获取当前线程操作的token;
     * @return
     */
    public static String getToken() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest().getHeader(HEADER);
    }
}

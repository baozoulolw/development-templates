package com.baozoulolw.wlog.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.baozoulolw.wlog.annotations.PassToken;
import com.baozoulolw.wlog.common.enums.RedisPreEnum;
import com.baozoulolw.wlog.entity.User;
import com.baozoulolw.wlog.utils.IpUtils;
import com.baozoulolw.wlog.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * token认证拦截器
 *
 * @author baozoulolw
 * @version 1.0
 * @date 2022-04-21 09:23
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Resource
    private RedisUtils redisUtil;

    private static final String HEADER = "Authorization";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader(HEADER);
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        if (token == null) {
            throw new RuntimeException("无token，请重新登录");
        }
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new Exception("token无效");
        }
        User user = null;
        String key = RedisPreEnum.JWT_TOKEN_PRE.getPre() + userId + IpUtils.getIpAddr(httpServletRequest);
        if (redisUtil.hasKey(key)) {
            Object o = redisUtil.get(key);
            user = JSONObject.toJavaObject((JSON) JSON.toJSON(o), User.class);
        }
        if (user == null) {
            throw new RuntimeException("请重新登录");
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (Exception e) {
            throw new Exception("token无效");
        }
        redisUtil.expire(key, RedisPreEnum.JWT_TOKEN_PRE.getExpired());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}

package com.baozoulolw.wlog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baozoulolw.wlog.common.Result;
import com.baozoulolw.wlog.common.enums.RedisPreEnum;
import com.baozoulolw.wlog.dao.UserDao;
import com.baozoulolw.wlog.entity.User;
import com.baozoulolw.wlog.service.UserService;
import com.baozoulolw.wlog.utils.IpUtils;
import com.baozoulolw.wlog.utils.JwtUtils;
import com.baozoulolw.wlog.utils.RedisUtils;
import com.baozoulolw.wlog.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * //
 *
 * @author baozoulolw
 * @version 1.0
 * @date 2022-04-15 16:15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Resource
    private RedisUtils redisUtil;

    /**
     * 登录接口
     *
     * @param user
     * @return
     */
    @Override
    public Result<Map<String, Object>> login(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        User one = this.getOne(wrapper);
        String ipAddr = IpUtils.getIpAddr(UserUtils.getRequest());
        if (one == null) {
            return Result.fail("登录失败，用户不存在");
        } else {
            if (!one.getPassword().equals(user.getPassword())) {
                return Result.fail("登录失败，密码错误");
            } else {
                String token = JwtUtils.getToken(one);
                String key = RedisPreEnum.JWT_TOKEN_PRE.getPre() + one.getId();
                Set<String> keys = redisUtil.keys(key + "*");
                if (CollectionUtils.isEmpty(keys)) {
                    redisUtil.set(key + ipAddr, 123, RedisPreEnum.JWT_TOKEN_PRE.getExpired());
                } else {
                    //请空之前的key
                    for (String k : keys) {
                        redisUtil.del(k);
                    }
                    //重新设置key
                    redisUtil.set(key + ipAddr, 123, RedisPreEnum.JWT_TOKEN_PRE.getExpired());
                }
                Map<String, Object> result = new HashMap<>(2);
                result.put("token", token);
                result.put("user", one);
                return Result.success(result);
            }
        }
    }
}

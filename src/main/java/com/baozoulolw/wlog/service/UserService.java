package com.baozoulolw.wlog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baozoulolw.wlog.common.Result;
import com.baozoulolw.wlog.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public interface UserService extends IService<User> {

    /**
     * 登录接口
     * @param user
     * @return
     */
    Result<Map<String, Object>> login(User user);
}

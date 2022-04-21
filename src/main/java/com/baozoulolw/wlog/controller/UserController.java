package com.baozoulolw.wlog.controller;

import com.baozoulolw.wlog.annotations.PassToken;
import com.baozoulolw.wlog.common.Result;
import com.baozoulolw.wlog.entity.User;
import com.baozoulolw.wlog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;


/**
 * 用户相关接口
 *
 * @author baozoulolw
 * @version 1.0
 * @date 2022-04-15 15:58
 */
@RestController
@RequestMapping(value = "/user")
@Api(value = "用于用户登录，获取用户信息等的接口",tags = "用于用户登录，获取用户信息等的接口")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 登录接口
     * @param user
     * @return
     */
    @PassToken
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<Map<String,Object>> login(@RequestBody User user) {
         return userService.login(user);
    }
}

package com.baozoulolw.wlog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baozoulolw.wlog.common.publicfields.IdEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;



import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author Baozoulolw
 * @version 1.0
 * @date 2021-06-09 10:43
 */
@Data
@TableName(value = "tb_user")
public class User extends IdEntity implements Serializable {

    /**
     * 登录用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码,需加密存储
     */
    @TableField(value = "password")
    private String password;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 性别 ，0：女 1：男
     */
    @TableField(value = "gender")
    private int gender;

    /**
     * 手机号码
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 生日
     */
    @TableField(value = "birthday")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date birthday;

}

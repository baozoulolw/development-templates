package com.baozoulolw.wlog.common.enums;


/**
 * 返回response状态码枚举类型
 *
 * @author baozoulolw
 * @version 1.0
 * @date 2022-04-15 15:53
 */

public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(1000, "请求成功"),
    /* 失败状态码 */
    FAILED(1001, "请求失败"),

    /* 新增成功状态码 */
    INSERT_SUCCESS(1100, "请求成功"),

    /* 新增失败状态码 */
    INSERT_FAILED(1101, "新增失败"),

    /* 登录成功状态码 */
    LOGIN_SUCCESS(2000, "登录成功"),

    /* 登录失败状态码 */
    LOGIN_FAILED(2001, "登录失败"),
    USER_NEED_AUTHORITIES(2011, "用户需要认证"),

    /* 系统500错误*/
    SYSTEM_ERROR(10000, "系统异常，请稍后重试"),
    UNAUTHORIZED(10401, "签名验证失败"),

    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),

    /* 用户错误：20001-29999*/
    USER_HAS_EXISTED(20001, "用户名已存在"),
    USER_NOT_FIND(20002, "用户名不存在");

    private final Integer code;

    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

}

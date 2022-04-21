package com.baozoulolw.wlog.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * redis key前缀
 */
@AllArgsConstructor
@Getter
public enum RedisPreEnum {
    /**
     * token前缀
     */
    JWT_TOKEN_PRE("JWT_TOKEN_","token前缀",60*60*24);

    /**
     * 名称
     */
    private String pre;
    /**
     * 描述
     */
    private String desc;
    /**
     * 过期时间
     */
    private Integer expired;
}

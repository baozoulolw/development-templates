package com.baozoulolw.wlog.common.page;

import lombok.Data;

/**
 * 分页查询请求对象
 *
 * @author baozoulolw
 * @version 1.0
 * @date 2021-12-01 15:04
 */
@Data
public class PageSearch<T> {
    private int pageSize;
    private int pageNumber;
    private T param;
}

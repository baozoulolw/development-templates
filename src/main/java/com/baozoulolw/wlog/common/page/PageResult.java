package com.baozoulolw.wlog.common.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.util.List;

@Data
public class PageResult {
    /**
     * 总记录数
     */
    private int totalCount;
    /**
     * 每页记录数
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 当前页数
     */
    private int curPage;
    /**
     * 列表数据
     */
    private List<?> list;

    /**
     * 分页
     */
    public PageResult(IPage<?> page) {
        this.list = page.getRecords();
        this.totalCount = (int)page.getTotal();
        this.pageSize = (int)page.getSize();
        this.curPage = (int)page.getCurrent();
        this.totalPage = (int)page.getPages();
    }
}

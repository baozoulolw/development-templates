package com.baozoulolw.wlog.config.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.dialects.MySqlDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis-plus分页配置类
 *
 * @author baozoulolw
 * @version 1.0
 * @date 2022-04-15 16:15
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialect(new MySqlDialect());
        /* 若setDialect不能使用，则用这个page.setDialectType("mysql"); */
        return page;
    }
}


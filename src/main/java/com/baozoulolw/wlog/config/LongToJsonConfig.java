package com.baozoulolw.wlog.config;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * 配置spring boot内嵌的Jackson序列化与反序列化类型映射 序列换成json时,将所有的long变成string， 因为js中得数字类型不能包含所有的java long值
 *
 * @author Baozoulolw
 * @version 1.0
 * @date 2021-01-22 9:50
 */
@Configuration
public class LongToJsonConfig {

    /**
     * 解决Jackson导致Long型数据精度丢失问题
     *
     * @return 返回Jackson2ObjectMapperBuilderCustomizer实例
     */
    @Bean("jackson2ObjectMapperBuilderCustomizer")
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        Jackson2ObjectMapperBuilderCustomizer customizer = new Jackson2ObjectMapperBuilderCustomizer() {

            @Override
            public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
                jacksonObjectMapperBuilder.serializerByType(Long.class, ToStringSerializer.instance)
                        .serializerByType(Long.TYPE, ToStringSerializer.instance);
                // 值为null时不序列化，此处会导致前端渲染时多判断一层（data）
                // jacksonObjectMapperBuilder.serializationInclusion(JsonInclude.Include.NON_NULL);
                // 忽略未知字段
                jacksonObjectMapperBuilder.failOnUnknownProperties(false);
            }
        };
        return customizer;
    }
}

package com.baozoulolw.wlog.config.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 阿里云oss对象
 *
 * @author baozoulolw
 * @version 1.0
 * @date 2022-01-29 14:49
 */
@Configuration
public class OssClientBeanConfig {

    @Value("${aliyun.oss.end-point}")
    private String endpoint;

    @Value("${aliyun.oss.access-key}")
    private String accessKeyId;

    @Value("${aliyun.oss.secret-key}")
    private String accessKeySecret;


    @Bean
    public OSS oss() {
        return new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }
}

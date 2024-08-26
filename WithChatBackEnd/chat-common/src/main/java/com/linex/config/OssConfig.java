package com.linex.config;

import com.linex.utils.MinIoOssUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OSS 配置类
 * @author linexsong
 */
@Configuration
public class OssConfig {
    /**
     * 配置本地 MinIO OSS
     * @param properties MinIO 配置项
     * @return 自定义 MinIo 工具类
     */
    @ConditionalOnMissingBean
    @Bean
    MinIoOssUtils minIoOssUtils(MinIoProperties properties) {
        return MinIoOssUtils.builder()
                .endpoint(properties.getEndpoint())
                .bucket(properties.getBucket())
                .access(properties.getAccess())
                .secret(properties.getSecret())
                .build();
    }
}

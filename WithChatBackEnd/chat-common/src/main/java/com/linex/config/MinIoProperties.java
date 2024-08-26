package com.linex.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author linexsong
 */
@Data
@Component
@ConfigurationProperties(prefix = "chat.minio")
public class MinIoProperties {
    private String endpoint;
    private String bucket;
    private String access;
    private String secret;

}

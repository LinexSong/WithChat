package com.linex.utils;

import com.linex.constant.ExceptionCont;
import com.linex.exceptions.OssException;
import io.minio.*;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

/**
 * MinIO OSS 本地对象存储工具类
 *
 * @author linexsong
 */
@Data
@Builder
@Slf4j
public class MinIoOssUtils {
    private String endpoint;
    private String access;
    private String secret;
    private String bucket;

    private MinioClient client;

    @PostConstruct
    private void initClient() {
        log.info("初始化 Minio 客户端: {}-{}-{}", bucket, access, secret);

        // 初始化 Minio 客户端
        client = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(access, secret)
                .build();
        // 检查 Bucket 是否存在
        try {
            if (!client.bucketExists(BucketExistsArgs.builder().bucket(bucket).build())) {
                throw new OssException(ExceptionCont.OSS_BUCKET_NOT_EXISTS);
            }
        } catch (Exception e) {
            throw new OssException(ExceptionCont.OSS_INIT_ERROR + e);
        }
    }

    /**
     * 上传文件
     *
     * @param file 文件对象
     */
    public void uploadObject(MultipartFile file) {
        try (InputStream is = file.getInputStream()) {
            // 文件名称
            String filename = file.getOriginalFilename();
            // 配置 pubObjectArgs
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .bucket(bucket)
                    .object(filename)
                    .stream(is, file.getSize(), -1)
                    .contentType(file.getContentType())
                    .build();
            // 上传文件
            client.putObject(putObjectArgs);

        } catch (Exception e) {
            // 文件上传失败
            throw new OssException(ExceptionCont.OSS_UPLOAD_ERROR);
        }
    }

    /**
     * 获取指定对象至响应
     *
     * @param objName  对象名
     * @param response 响应对象
     */
    public void getObjectToResponse(String objName, HttpServletResponse response) {
        try (InputStream is = client.getObject(
                GetObjectArgs.builder()
                        .bucket(bucket)
                        .object(objName)
                        .build()
        )) {
            // 获取对象状态
            StatObjectResponse stat = client.statObject(StatObjectArgs.builder().bucket(bucket).object(objName).build());
            response.setContentType(stat.contentType());
            // 将 IO 流返回至响应
            IOUtils.copy(is, response.getOutputStream());
        } catch (Exception e) {
            throw new OssException(ExceptionCont.OSS_GET_ERROR);

        }
    }


}

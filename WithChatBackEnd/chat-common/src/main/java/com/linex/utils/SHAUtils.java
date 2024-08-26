package com.linex.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * SHA 加密工具
 * @author linexsong
 */
@Slf4j
@Component
public class ShaUtils {
    public static String encode(@NotNull String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes(StandardCharsets.UTF_8));
            return String.valueOf(Hex.encodeHex(md.digest()));
        } catch (NoSuchAlgorithmException e) {
            log.error("加密失败，没有该加密方法: {}", e.toString());
            return null;
        }
    }

    public static boolean compare(String str, String hex) {
        return Objects.equals(ShaUtils.encode(str), hex);
    }
}

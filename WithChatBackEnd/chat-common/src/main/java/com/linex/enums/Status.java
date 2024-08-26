package com.linex.enums;


import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @author linexsong
 */
@Getter
public enum Status {
    /**
     * 0 - 成功
     */
    SUCCESS(0, "success"),
    ERROR(1, "fail");
    @JsonValue
    private final Integer code;
    private final String desc;

    Status(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}

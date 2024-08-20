package com.linex.enums;


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
    ERROR(1, "fail")
    ;
    private Integer code;
    private String desc;

    Status(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}

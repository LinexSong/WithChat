package com.linex.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linexsong
 */
@Data
public class UserDto implements Serializable {
    private Integer uid;
    @JsonProperty(value = "uPwd")
    private String uPwd;
}

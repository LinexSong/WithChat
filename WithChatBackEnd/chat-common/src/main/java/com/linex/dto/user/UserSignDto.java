package com.linex.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author linexsong
 */
@Data
public class UserSignDto implements Serializable {
    private String nickname;
    @JsonProperty("uPwd")
    private String uPwd;
}

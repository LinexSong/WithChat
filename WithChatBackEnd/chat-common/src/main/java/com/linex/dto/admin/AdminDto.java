package com.linex.dto.admin;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linexsong
 */
@Data
public class AdminDto implements Serializable {
    Integer aid;
    @JsonProperty(value = "aPwd")
    String aPwd;

}

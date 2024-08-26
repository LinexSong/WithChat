package com.linex.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.linex.domain.pojo.ChatAdmin;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author linexsong
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(value = {"aPwd"})
public class AdminVo extends ChatAdmin {
}

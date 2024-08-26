package com.linex.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.linex.domain.pojo.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author linexsong
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(value = {"uPwd", "unmanaged"})
public class UserVo extends User implements Serializable {

}

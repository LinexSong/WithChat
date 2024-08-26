package com.linex.domain.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linexsong
 */
@Data
@TableName("chat_user")
public class User implements Serializable {
    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;
    private String nickname;
    @JsonProperty(value = "uSig")
    private String uSig;
    @JsonProperty(value = "uAvatar")
    private String uAvatar;
    private String chatMode;
    @JsonProperty(value = "uPwd")
    private String uPwd;
    private Boolean disabled;
    private Boolean unmanaged;

}

package com.linex.domain.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linexsong
 */
@Data
@TableName("chat_user")
public class User implements Serializable {
    @TableId("uid")
    private Integer uid;
    private String nickname;
    private String uSig;
    private String uAvatar;
    private String chatMode;
    private String uPwd;
    private Boolean disabled;
    private Boolean unmanaged;

}

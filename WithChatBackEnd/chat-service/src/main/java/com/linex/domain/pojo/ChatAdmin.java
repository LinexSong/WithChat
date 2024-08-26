package com.linex.domain.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author linexsong
 * @since 2024-08-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("chat_admin")
public class ChatAdmin implements Serializable {
    /**
     * 管理员 ID
     */
    @TableId(value = "aid", type = IdType.AUTO)
    private Integer aid;

    /**
     * 管理员名称
     */
    @JsonProperty(value = "aName")
    private String aName;

    /**
     * 管理员密码
     */
    @JsonProperty(value = "aPwd")
    private String aPwd;

    /**
     * 账号是否启用 0-启用 1-停用
     */
    private Boolean disabled;

    /**
     * 负责管理用户人数
     */
    private Integer respU;

    /**
     * 负责管理群数
     */
    private Integer respG;

    /**
     * 管理用户起始编号
     */
    private Integer respUserStart;


}

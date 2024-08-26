package com.linex.domain.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("chat_single_msg")
public class SingleMsg implements Serializable {

    /**
     * 消息 ID
     */
    @TableId(value = "msg_id", type = IdType.AUTO)
    private Long msgId;

    /**
     * 消息发起者用户 ID
     */
    private Integer sendUid;

    /**
     * 目标用户 ID
     */
    private Integer desUid;

    /**
     * 消息内容
     */
    private String msg;

    /**
     * 消息发送时间
     */
    private LocalDateTime time;

    /**
     * 消息类型 0-临时消息, 1-群临时消息, 2-好友消息
     */
    private String msgType;

    /**
     * 是否已读 0-已读, 1-未读
     */
    private Boolean received;


}

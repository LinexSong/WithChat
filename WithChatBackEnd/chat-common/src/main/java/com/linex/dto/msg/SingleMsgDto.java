package com.linex.dto.msg;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author linexsong
 */
@Data
public class SingleMsgDto implements Serializable {
    Integer sendUid;
    String msg;
    LocalDateTime time;
    String msgType;
}

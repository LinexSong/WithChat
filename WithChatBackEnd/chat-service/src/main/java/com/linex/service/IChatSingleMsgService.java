package com.linex.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.linex.domain.pojo.SingleMsg;
import com.linex.dto.msg.SingleMsgDto;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author linexsong
 * @since 2024-08-26
 */
public interface IChatSingleMsgService extends IService<SingleMsg> {

    /**
     * 发送信息
     *
     * @param uid 目标用户 ID
     * @param dto 信息数据传输对象
     * @return boolean
     */
    boolean send(Integer uid, SingleMsgDto dto);
}

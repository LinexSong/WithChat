package com.linex.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linex.constant.ExceptionCont;
import com.linex.domain.pojo.SingleMsg;
import com.linex.dto.msg.SingleMsgDto;
import com.linex.exceptions.ServiceException;
import com.linex.mapper.ChatSingleMsgMapper;
import com.linex.service.IChatSingleMsgService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author linexsong
 * @since 2024-08-26
 */
@Service
public class ChatSingleMsgServiceImpl extends ServiceImpl<ChatSingleMsgMapper, SingleMsg> implements IChatSingleMsgService {
    private final ChatSingleMsgMapper msgMapper;

    public ChatSingleMsgServiceImpl(ChatSingleMsgMapper msgMapper) {
        this.msgMapper = msgMapper;
    }

    @Override
    public boolean send(Integer uid, SingleMsgDto dto) {
        if (!checkValid(uid, dto.getSendUid())) {
            throw new ServiceException(ExceptionCont.MSG_NOT_PERMITTED);
        }
        // 复制对象属性并设置来源id
        SingleMsg msg = BeanUtil.copyProperties(dto, SingleMsg.class);
        msg.setDesUid(uid);
        return save(msg);
    }

    private boolean checkValid(Integer sid, Integer did) {
        return true;
    }
}

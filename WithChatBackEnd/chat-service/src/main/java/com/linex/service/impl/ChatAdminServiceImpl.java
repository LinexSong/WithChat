package com.linex.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linex.constant.ExceptionCont;
import com.linex.domain.pojo.ChatAdmin;
import com.linex.domain.vo.AdminVo;
import com.linex.dto.admin.AdminDto;
import com.linex.exceptions.ServiceException;
import com.linex.mapper.ChatAdminMapper;
import com.linex.service.IChatAdminService;
import com.linex.utils.ShaUtils;
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
public class ChatAdminServiceImpl extends ServiceImpl<ChatAdminMapper, ChatAdmin> implements IChatAdminService {
    @Override
    public AdminVo login(AdminDto dto) {
        ChatAdmin admin = getById(dto.getAid());
        
        if (admin != null && ShaUtils.compare(dto.getAPwd(), admin.getAPwd())) {
            return BeanUtil.copyProperties(admin, AdminVo.class);
        }
        throw new ServiceException(ExceptionCont.ADMIN_VERIFY_ERR);
    }
}

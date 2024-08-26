package com.linex.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.linex.domain.pojo.ChatAdmin;
import com.linex.domain.vo.AdminVo;
import com.linex.dto.admin.AdminDto;

/**
 * <p>
 * 管理员服务类
 * </p>
 *
 * @author linexsong
 * @since 2024-08-26
 */
public interface IChatAdminService extends IService<ChatAdmin> {

    /**
     * 管理员登陆
     *
     * @param dto 管理员数据传输对象
     * @return 管理员视图对象
     */
    AdminVo login(AdminDto dto);
}

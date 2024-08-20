package com.linex.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.linex.domain.pojo.User;
import com.linex.dto.user.UserDto;
import com.linex.vo.user.UserVo;
import org.springframework.stereotype.Service;

/**
 * @author linexsong
 */
public interface IUserService extends IService<User> {
    /**
     * 用户登陆接口
     * @param userDto
     * @return
     */
    UserVo login(UserDto userDto);
}

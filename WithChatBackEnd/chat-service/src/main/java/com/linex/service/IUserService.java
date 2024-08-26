package com.linex.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.linex.domain.pojo.User;
import com.linex.dto.user.UserDto;
import com.linex.dto.user.UserSignDto;
import com.linex.domain.vo.UserVo;

/**
 * @author linexsong
 */
public interface IUserService extends IService<User> {
    /**
     * 用户登陆接口
     * @param userDto user 实体类DTO
     * @return UserVo
     */
    UserVo login(UserDto userDto);


    /**
     * 用户注册接口
     * @param signDto User 实体类注册专用DTO
     * @return UserVo
     */
    UserVo signUp(UserSignDto signDto);
}

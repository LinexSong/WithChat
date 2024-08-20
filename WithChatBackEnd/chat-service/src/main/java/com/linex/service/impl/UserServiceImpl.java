package com.linex.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linex.domain.pojo.User;
import com.linex.dto.user.UserDto;
import com.linex.mapper.user.UserMapper;
import com.linex.service.IUserService;
import com.linex.vo.user.UserVo;
import org.springframework.stereotype.Service;

/**
 * @author linexsong
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public UserVo login(UserDto userDto) {
        return null;
    }
}

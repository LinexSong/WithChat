package com.linex.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linex.constant.ExceptionCont;
import com.linex.constant.UserServiceCont;
import com.linex.domain.pojo.User;
import com.linex.domain.vo.UserVo;
import com.linex.dto.user.UserDto;
import com.linex.dto.user.UserSignDto;
import com.linex.exceptions.ServiceException;
import com.linex.mapper.UserMapper;
import com.linex.service.IUserService;
import com.linex.utils.ShaUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author linexsong
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private final UserMapper userMapper;

    @Override
    public UserVo login(UserDto userDto) {
        log.info("用户登陆: {}", userDto);
        User user = getById(userDto.getUid());
        // 验证用户及密码
        if (user != null && ShaUtils.compare(userDto.getUPwd(), user.getUPwd())) {
            return BeanUtil.copyProperties(user, UserVo.class);
        }
        // 密码验证有误
        throw new ServiceException(ExceptionCont.USER_VERIFICATION_ERR);
    }


    @Override
    public UserVo signUp(UserSignDto signDto) {
        log.info("用户注册: {}", signDto);
        String pwd = signDto.getUPwd();
        if (!verifyPwd(pwd)) {
            throw new ServiceException(ExceptionCont.USER_PWD_FORMAT_ERR);
        }
        // 密码加密
        String newPwd = ShaUtils.encode(pwd);
        if (newPwd == null) {
            throw new ServiceException(ExceptionCont.USER_PWD_TO_SHA_ERR);
        }
        // 用户注册
        User user = BeanUtil.copyProperties(signDto, User.class);
        user.setUPwd(newPwd);
        if (!save(user)) {
            throw new ServiceException(ExceptionCont.USER_SIGNUP_ERROR);
        }
        return BeanUtil.copyProperties(getById(user.getUid()), UserVo.class);
    }

    /**
     * 验证密码格式
     *
     * @param pwd 密码字符串
     * @return bool
     */
    private boolean verifyPwd(String pwd) {
        if (StrUtil.isBlank(pwd)) {
            return false;
        }
        if (pwd.length() < UserServiceCont.PWD_MIN_LENGTH) {
            return false;
        }
        return pwd.length() <= UserServiceCont.PWD_MAX_LENGTH;
    }
}

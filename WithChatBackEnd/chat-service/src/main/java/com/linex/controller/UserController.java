package com.linex.controller;

import com.linex.dto.user.UserDto;
import com.linex.service.IUserService;
import com.linex.vo.Result;
import com.linex.vo.user.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author linexsong
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @GetMapping("/login")
    public Result<UserVo> login(@RequestBody UserDto userDto) {
        return Result.success(userService.login(userDto));
    }
}

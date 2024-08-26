package com.linex.controller;

import com.linex.dto.user.UserDto;
import com.linex.dto.user.UserSignDto;
import com.linex.service.IUserService;
import com.linex.result.Result;
import com.linex.domain.vo.UserVo;
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

    @PostMapping("/sign")
    public Result<UserVo> signUp(@RequestBody UserSignDto signDto) {
        return Result.success(userService.signUp(signDto));
    }
}

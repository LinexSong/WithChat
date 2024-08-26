package com.linex.controller;


import com.linex.domain.vo.AdminVo;
import com.linex.dto.admin.AdminDto;
import com.linex.result.Result;
import com.linex.service.IChatAdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 管理员前端控制器
 * </p>
 *
 * @author linexsong
 * @since 2024-08-26
 */
@RestController
@RequestMapping("/admin")
public class ChatAdminController {
    private final IChatAdminService service;

    ChatAdminController(IChatAdminService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public Result<AdminVo> login(@RequestBody AdminDto dto) {
        return Result.success(service.login(dto));
    }
}

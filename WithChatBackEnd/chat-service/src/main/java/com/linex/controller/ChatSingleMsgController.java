package com.linex.controller;


import com.linex.dto.msg.SingleMsgDto;
import com.linex.result.Result;
import com.linex.service.IChatSingleMsgService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author
 * @since 2024-08-26
 */
@RestController
@RequestMapping("/send")
public class ChatSingleMsgController {
    private final IChatSingleMsgService service;

    public ChatSingleMsgController(IChatSingleMsgService service) {
        this.service = service;
    }

    @PostMapping("/{uid}")
    public Result<?> sendMessage(@PathVariable Integer uid, @RequestBody SingleMsgDto dto) {
        return service.send(uid, dto) ? Result.success() : Result.error(null);
    }

}

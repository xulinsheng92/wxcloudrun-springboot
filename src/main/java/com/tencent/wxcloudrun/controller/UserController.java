package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.model.response.ApiResponse;
import com.tencent.wxcloudrun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/openid/{openid}")
    public ApiResponse<User> getByOpenId(@PathVariable String openid) {
        return ApiResponse.success(userService.getByOpenId(openid));
    }

    @PostMapping
    public ApiResponse<Boolean> save(@RequestBody User user) {
        return ApiResponse.success(userService.save(user));
    }

    @PutMapping("/{id}")
    public ApiResponse<Boolean> update(@PathVariable Integer id, @RequestBody User user) {
        user.setUserId(id);
        return ApiResponse.success(userService.updateById(user));
    }
} 
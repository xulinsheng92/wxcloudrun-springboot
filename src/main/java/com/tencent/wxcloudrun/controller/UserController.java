package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.model.response.ApiResponse;
import com.tencent.wxcloudrun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理控制器
 * 处理用户相关的HTTP请求，包括查询、创建和更新用户信息
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据微信OpenID获取用户信息
     * @param openid 微信OpenID
     * @return 用户信息
     */
    @GetMapping("/openid/{openid}")
    public ApiResponse<User> getByOpenId(@PathVariable String openid) {
        return ApiResponse.success(userService.getByOpenId(openid));
    }

    /**
     * 创建新用户
     * @param user 用户信息
     * @return 创建结果
     */
    @PostMapping
    public ApiResponse<Boolean> save(@RequestBody User user) {
        return ApiResponse.success(userService.save(user));
    }

    /**
     * 更新用户信息
     * @param id 用户ID
     * @param user 更新的用户信息
     * @return 更新结果
     */
    @PutMapping("/{id}")
    public ApiResponse<Boolean> update(@PathVariable Integer id, @RequestBody User user) {
        user.setUserId(id);
        return ApiResponse.success(userService.updateById(user));
    }
} 
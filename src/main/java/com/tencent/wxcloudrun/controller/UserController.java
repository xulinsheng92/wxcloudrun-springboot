package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/openid/{openid}")
    public User getByOpenId(@PathVariable String openid) {
        return userService.getByOpenId(openid);
    }

    @PostMapping
    public boolean save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable Integer id, @RequestBody User user) {
        user.setUserId(id);
        return userService.updateById(user);
    }
} 
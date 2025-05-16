package com.tencent.wxcloudrun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tencent.wxcloudrun.model.User;

public interface UserService extends IService<User> {
    // 根据微信 OpenID 获取用户
    User getByOpenId(String openId);
} 
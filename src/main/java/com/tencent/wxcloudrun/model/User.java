package com.tencent.wxcloudrun.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("users")
public class User {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    
    private String nickname;
    private String phone;
    private String wxOpenid;
} 
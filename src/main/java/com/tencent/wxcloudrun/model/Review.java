package com.tencent.wxcloudrun.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("reviews")
public class Review {
    @TableId(value = "review_id", type = IdType.AUTO)
    private Integer reviewId;
    
    private Integer orderDetailId;
    private Integer userId;
    private Integer rating;
    private String comment;
    
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;
} 
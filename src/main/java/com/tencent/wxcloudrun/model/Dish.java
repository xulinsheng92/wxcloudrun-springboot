package com.tencent.wxcloudrun.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@TableName("dishes")
public class Dish {
    @TableId(value = "dish_id", type = IdType.AUTO)
    private Integer dishId;
    
    private String dishName;
    private String dishImageUrl;
    private String description;
    private BigDecimal price;
    
    @TableField(value = "is_available")
    private Boolean isAvailable;
} 
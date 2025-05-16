package com.tencent.wxcloudrun.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@TableName("cart")
public class Cart {
    @TableId(value = "cart_id", type = IdType.AUTO)
    private Integer cartId;
    
    private Integer userId;
    private Integer dishId;
    private Integer quantity;
    private BigDecimal createdAt;
} 
package com.tencent.wxcloudrun.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("orders")
public class Order {
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;
    
    private Integer userId;
    private BigDecimal totalAmount;
    private String orderStatus;
    
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;
    
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;
} 
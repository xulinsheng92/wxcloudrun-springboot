package com.tencent.wxcloudrun.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@TableName("order_details")
public class OrderDetail {
    @TableId(value = "order_detail_id", type = IdType.AUTO)
    private Integer orderDetailId;
    
    private Integer orderId;
    private Integer dishId;
    private Integer quantity;
    private BigDecimal price;
} 
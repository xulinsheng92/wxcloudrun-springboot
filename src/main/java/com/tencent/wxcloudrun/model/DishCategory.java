package com.tencent.wxcloudrun.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("dish_categories")
public class DishCategory {
    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;
    
    private String categoryName;
    private Integer sortOrder;
    private Boolean isAvailable;
    
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;
    
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;
} 
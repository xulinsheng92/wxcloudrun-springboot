package com.tencent.wxcloudrun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tencent.wxcloudrun.model.Dish;
import java.util.List;

public interface DishService extends IService<Dish> {
    // 获取所有可用的菜品
    List<Dish> getAvailableDishes();
    
    // 更新菜品状态
    boolean updateAvailableStatus(Integer dishId, Boolean isAvailable);
} 
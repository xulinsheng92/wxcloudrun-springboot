package com.tencent.wxcloudrun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tencent.wxcloudrun.model.Dish;
import java.util.List;

public interface DishService extends IService<Dish> {
    // 获取所有可用的菜品
    List<Dish> getAvailableDishes();
    
    // 获取所有菜品（包含不可用）
    List<Dish> getAllDishes();
    
    // 更新菜品状态
    boolean updateAvailableStatus(Integer dishId, Boolean isAvailable);
    
    // 根据分类ID获取可用菜品
    List<Dish> getAvailableDishesByCategory(Integer categoryId);
    
    // 根据分类ID获取所有菜品
    List<Dish> getAllDishesByCategory(Integer categoryId);
    
    // 更新菜品排序
    boolean updateSortOrder(Integer dishId, Integer sortOrder);
} 
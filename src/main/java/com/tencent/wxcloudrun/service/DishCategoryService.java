package com.tencent.wxcloudrun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tencent.wxcloudrun.model.DishCategory;
import java.util.List;

public interface DishCategoryService extends IService<DishCategory> {
    // 获取所有可用的分类
    List<DishCategory> getAvailableCategories();
    
    // 获取所有分类（包含不可用）
    List<DishCategory> getAllCategories();
    
    // 更新分类状态
    boolean updateAvailableStatus(Integer categoryId, Boolean isAvailable);
    
    // 更新分类排序
    boolean updateSortOrder(Integer categoryId, Integer sortOrder);
} 
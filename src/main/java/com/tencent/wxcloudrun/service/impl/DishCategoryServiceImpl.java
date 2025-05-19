package com.tencent.wxcloudrun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tencent.wxcloudrun.dao.DishCategoryMapper;
import com.tencent.wxcloudrun.model.DishCategory;
import com.tencent.wxcloudrun.service.DishCategoryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DishCategoryServiceImpl extends ServiceImpl<DishCategoryMapper, DishCategory> implements DishCategoryService {
    
    @Override
    public List<DishCategory> getAvailableCategories() {
        LambdaQueryWrapper<DishCategory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishCategory::getIsAvailable, true)
                   .orderByAsc(DishCategory::getSortOrder);
        return list(queryWrapper);
    }
    
    @Override
    public List<DishCategory> getAllCategories() {
        LambdaQueryWrapper<DishCategory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(DishCategory::getSortOrder);
        return list(queryWrapper);
    }
    
    @Override
    public boolean updateAvailableStatus(Integer categoryId, Boolean isAvailable) {
        DishCategory category = new DishCategory();
        category.setCategoryId(categoryId);
        category.setIsAvailable(isAvailable);
        return updateById(category);
    }
    
    @Override
    public boolean updateSortOrder(Integer categoryId, Integer sortOrder) {
        DishCategory category = new DishCategory();
        category.setCategoryId(categoryId);
        category.setSortOrder(sortOrder);
        return updateById(category);
    }
} 
package com.tencent.wxcloudrun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tencent.wxcloudrun.dao.DishMapper;
import com.tencent.wxcloudrun.model.Dish;
import com.tencent.wxcloudrun.service.DishService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    
    @Override
    public List<Dish> getAvailableDishes() {
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Dish::getIsAvailable, true)
                   .orderByAsc(Dish::getSortOrder);
        return list(queryWrapper);
    }
    
    /**
     * 获取所有菜品（包含不可用）
     */
    @Override
    public List<Dish> getAllDishes() {
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Dish::getSortOrder);
        return list(queryWrapper);
    }
    
    @Override
    public boolean updateAvailableStatus(Integer dishId, Boolean isAvailable) {
        Dish dish = new Dish();
        dish.setDishId(dishId);
        dish.setIsAvailable(isAvailable);
        return updateById(dish);
    }
    
    @Override
    public List<Dish> getAvailableDishesByCategory(Integer categoryId) {
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Dish::getCategoryId, categoryId)
                   .eq(Dish::getIsAvailable, true)
                   .orderByAsc(Dish::getSortOrder);
        return list(queryWrapper);
    }
    
    @Override
    public List<Dish> getAllDishesByCategory(Integer categoryId) {
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Dish::getCategoryId, categoryId)
                   .orderByAsc(Dish::getSortOrder);
        return list(queryWrapper);
    }
    
    @Override
    public boolean updateSortOrder(Integer dishId, Integer sortOrder) {
        Dish dish = new Dish();
        dish.setDishId(dishId);
        dish.setSortOrder(sortOrder);
        return updateById(dish);
    }
} 
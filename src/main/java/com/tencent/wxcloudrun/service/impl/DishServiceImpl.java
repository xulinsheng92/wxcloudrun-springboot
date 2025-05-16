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
        queryWrapper.eq(Dish::getIsAvailable, true);
        return list(queryWrapper);
    }
    
    @Override
    public boolean updateAvailableStatus(Integer dishId, Boolean isAvailable) {
        Dish dish = new Dish();
        dish.setDishId(dishId);
        dish.setIsAvailable(isAvailable);
        return updateById(dish);
    }
} 
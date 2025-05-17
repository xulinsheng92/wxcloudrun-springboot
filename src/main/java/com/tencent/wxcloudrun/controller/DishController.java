package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Dish;
import com.tencent.wxcloudrun.model.response.ApiResponse;
import com.tencent.wxcloudrun.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/available")
    public ApiResponse<List<Dish>> getAvailableDishes() {
        return ApiResponse.success(dishService.getAvailableDishes());
    }

    @GetMapping("/{id}")
    public ApiResponse<Dish> getById(@PathVariable Integer id) {
        return ApiResponse.success(dishService.getById(id));
    }

    @PostMapping
    public ApiResponse<Boolean> save(@RequestBody Dish dish) {
        return ApiResponse.success(dishService.save(dish));
    }

    @PutMapping("/{id}")
    public ApiResponse<Boolean> update(@PathVariable Integer id, @RequestBody Dish dish) {
        dish.setDishId(id);
        return ApiResponse.success(dishService.updateById(dish));
    }

    @PutMapping("/{id}/status")
    public ApiResponse<Boolean> updateStatus(@PathVariable Integer id, @RequestParam Boolean isAvailable) {
        return ApiResponse.success(dishService.updateAvailableStatus(id, isAvailable));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> delete(@PathVariable Integer id) {
        return ApiResponse.success(dishService.removeById(id));
    }
} 
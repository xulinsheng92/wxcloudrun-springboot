package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Dish;
import com.tencent.wxcloudrun.model.response.ApiResponse;
import com.tencent.wxcloudrun.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 菜品管理控制器
 * 处理菜品相关的HTTP请求，包括查询、创建、更新和删除菜品信息
 */
@RestController
@RequestMapping("/api/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    /**
     * 获取所有可用的菜品列表
     * @return 可用菜品列表
     */
    @GetMapping("/available")
    public ApiResponse<List<Dish>> getAvailableDishes() {
        return ApiResponse.success(dishService.getAvailableDishes());
    }

    /**
     * 根据分类ID获取可用菜品列表
     * @param categoryId 分类ID
     * @return 可用菜品列表
     */
    @GetMapping("/category/{categoryId}/available")
    public ApiResponse<List<Dish>> getAvailableDishesByCategory(@PathVariable Integer categoryId) {
        return ApiResponse.success(dishService.getAvailableDishesByCategory(categoryId));
    }

    /**
     * 根据分类ID获取所有菜品列表
     * @param categoryId 分类ID
     * @return 所有菜品列表
     */
    @GetMapping("/category/{categoryId}")
    public ApiResponse<List<Dish>> getAllDishesByCategory(@PathVariable Integer categoryId) {
        return ApiResponse.success(dishService.getAllDishesByCategory(categoryId));
    }

    /**
     * 根据ID获取菜品信息
     * @param id 菜品ID
     * @return 菜品信息
     */
    @GetMapping("/{id}")
    public ApiResponse<Dish> getById(@PathVariable Integer id) {
        return ApiResponse.success(dishService.getById(id));
    }

    /**
     * 创建新菜品
     * @param dish 菜品信息
     * @return 创建结果
     */
    @PostMapping
    public ApiResponse<Boolean> save(@RequestBody Dish dish) {
        return ApiResponse.success(dishService.save(dish));
    }

    /**
     * 更新菜品信息
     * @param id 菜品ID
     * @param dish 更新的菜品信息
     * @return 更新结果
     */
    @PutMapping("/{id}")
    public ApiResponse<Boolean> update(@PathVariable Integer id, @RequestBody Dish dish) {
        dish.setDishId(id);
        return ApiResponse.success(dishService.updateById(dish));
    }

    /**
     * 更新菜品上下架状态
     * @param id 菜品ID
     * @param isAvailable 是否可用
     * @return 更新结果
     */
    @PutMapping("/{id}/status")
    public ApiResponse<Boolean> updateStatus(@PathVariable Integer id, @RequestParam Boolean isAvailable) {
        return ApiResponse.success(dishService.updateAvailableStatus(id, isAvailable));
    }

    /**
     * 更新菜品排序
     * @param id 菜品ID
     * @param sortOrder 排序号
     * @return 更新结果
     */
    @PutMapping("/{id}/sort")
    public ApiResponse<Boolean> updateSort(@PathVariable Integer id, @RequestParam Integer sortOrder) {
        return ApiResponse.success(dishService.updateSortOrder(id, sortOrder));
    }

    /**
     * 删除菜品
     * @param id 菜品ID
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> delete(@PathVariable Integer id) {
        return ApiResponse.success(dishService.removeById(id));
    }

    /**
     * 获取所有菜品（包含不可用）
     * @return 所有菜品列表
     */
    @GetMapping("")
    public ApiResponse<List<Dish>> getAllDishes() {
        return ApiResponse.success(dishService.getAllDishes());
    }
} 
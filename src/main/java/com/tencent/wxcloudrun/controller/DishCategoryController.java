package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.DishCategory;
import com.tencent.wxcloudrun.model.response.ApiResponse;
import com.tencent.wxcloudrun.service.DishCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 菜品分类管理控制器
 */
@RestController
@RequestMapping("/api/categories")
public class DishCategoryController {

    @Autowired
    private DishCategoryService dishCategoryService;

    /**
     * 获取所有可用的分类列表
     * @return 可用分类列表
     */
    @GetMapping("/available")
    public ApiResponse<List<DishCategory>> getAvailableCategories() {
        return ApiResponse.success(dishCategoryService.getAvailableCategories());
    }

    /**
     * 根据ID获取分类信息
     * @param id 分类ID
     * @return 分类信息
     */
    @GetMapping("/{id}")
    public ApiResponse<DishCategory> getById(@PathVariable Integer id) {
        return ApiResponse.success(dishCategoryService.getById(id));
    }

    /**
     * 创建新分类
     * @param category 分类信息
     * @return 创建结果
     */
    @PostMapping
    public ApiResponse<Boolean> save(@RequestBody DishCategory category) {
        return ApiResponse.success(dishCategoryService.save(category));
    }

    /**
     * 更新分类信息
     * @param id 分类ID
     * @param category 更新的分类信息
     * @return 更新结果
     */
    @PutMapping("/{id}")
    public ApiResponse<Boolean> update(@PathVariable Integer id, @RequestBody DishCategory category) {
        category.setCategoryId(id);
        return ApiResponse.success(dishCategoryService.updateById(category));
    }

    /**
     * 更新分类状态
     * @param id 分类ID
     * @param isAvailable 是否可用
     * @return 更新结果
     */
    @PutMapping("/{id}/status")
    public ApiResponse<Boolean> updateStatus(@PathVariable Integer id, @RequestParam Boolean isAvailable) {
        return ApiResponse.success(dishCategoryService.updateAvailableStatus(id, isAvailable));
    }

    /**
     * 更新分类排序
     * @param id 分类ID
     * @param sortOrder 排序号
     * @return 更新结果
     */
    @PutMapping("/{id}/sort")
    public ApiResponse<Boolean> updateSort(@PathVariable Integer id, @RequestParam Integer sortOrder) {
        return ApiResponse.success(dishCategoryService.updateSortOrder(id, sortOrder));
    }

    /**
     * 删除分类
     * @param id 分类ID
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> delete(@PathVariable Integer id) {
        return ApiResponse.success(dishCategoryService.removeById(id));
    }

    /**
     * 获取所有分类列表
     * @return 所有分类列表
     */
    @GetMapping("")
    public ApiResponse<List<DishCategory>> getAllCategories() {
        return ApiResponse.success(dishCategoryService.getAllCategories());
    }
} 
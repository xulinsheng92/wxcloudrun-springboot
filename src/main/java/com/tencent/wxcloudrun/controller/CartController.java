package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Cart;
import com.tencent.wxcloudrun.model.response.ApiResponse;
import com.tencent.wxcloudrun.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 购物车管理控制器
 * 处理购物车相关的HTTP请求，包括查询、添加、更新和删除购物车项
 */
@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 获取用户的购物车列表
     * @param userId 用户ID
     * @return 购物车项列表
     */
    @GetMapping("/user/{userId}")
    public ApiResponse<List<Cart>> getUserCart(@PathVariable Integer userId) {
        return ApiResponse.success(cartService.getUserCart(userId));
    }

    /**
     * 添加商品到购物车
     * @param cart 购物车项信息
     * @return 添加结果
     */
    @PostMapping
    public ApiResponse<Boolean> add(@RequestBody Cart cart) {
        return ApiResponse.success(cartService.save(cart));
    }

    /**
     * 更新购物车项数量
     * @param id 购物车项ID
     * @param quantity 更新的数量
     * @return 更新结果
     */
    @PutMapping("/{id}/quantity")
    public ApiResponse<Boolean> updateQuantity(@PathVariable Integer id, @RequestParam Integer quantity) {
        return ApiResponse.success(cartService.updateQuantity(id, quantity));
    }

    /**
     * 清空用户的购物车
     * @param userId 用户ID
     * @return 清空结果
     */
    @DeleteMapping("/user/{userId}")
    public ApiResponse<Boolean> clearUserCart(@PathVariable Integer userId) {
        return ApiResponse.success(cartService.clearUserCart(userId));
    }

    /**
     * 从购物车中删除指定项
     * @param id 购物车项ID
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> removeItem(@PathVariable Integer id) {
        return ApiResponse.success(cartService.removeById(id));
    }
} 
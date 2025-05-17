package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Cart;
import com.tencent.wxcloudrun.model.response.ApiResponse;
import com.tencent.wxcloudrun.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/user/{userId}")
    public ApiResponse<List<Cart>> getUserCart(@PathVariable Integer userId) {
        return ApiResponse.success(cartService.getUserCart(userId));
    }

    @PostMapping
    public ApiResponse<Boolean> add(@RequestBody Cart cart) {
        return ApiResponse.success(cartService.save(cart));
    }

    @PutMapping("/{id}/quantity")
    public ApiResponse<Boolean> updateQuantity(@PathVariable Integer id, @RequestParam Integer quantity) {
        return ApiResponse.success(cartService.updateQuantity(id, quantity));
    }

    @DeleteMapping("/user/{userId}")
    public ApiResponse<Boolean> clearUserCart(@PathVariable Integer userId) {
        return ApiResponse.success(cartService.clearUserCart(userId));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> removeItem(@PathVariable Integer id) {
        return ApiResponse.success(cartService.removeById(id));
    }
} 
package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Cart;
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
    public List<Cart> getUserCart(@PathVariable Integer userId) {
        return cartService.getUserCart(userId);
    }

    @PostMapping
    public boolean add(@RequestBody Cart cart) {
        return cartService.save(cart);
    }

    @PutMapping("/{id}/quantity")
    public boolean updateQuantity(@PathVariable Integer id, @RequestParam Integer quantity) {
        return cartService.updateQuantity(id, quantity);
    }

    @DeleteMapping("/user/{userId}")
    public boolean clearUserCart(@PathVariable Integer userId) {
        return cartService.clearUserCart(userId);
    }

    @DeleteMapping("/{id}")
    public boolean removeItem(@PathVariable Integer id) {
        return cartService.removeById(id);
    }
} 
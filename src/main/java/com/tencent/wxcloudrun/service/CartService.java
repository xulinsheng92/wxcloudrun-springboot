package com.tencent.wxcloudrun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tencent.wxcloudrun.model.Cart;
import java.util.List;

public interface CartService extends IService<Cart> {
    // 获取用户的购物车
    List<Cart> getUserCart(Integer userId);
    
    // 更新购物车中的商品数量
    boolean updateQuantity(Integer cartId, Integer quantity);
    
    // 清空用户购物车
    boolean clearUserCart(Integer userId);
} 
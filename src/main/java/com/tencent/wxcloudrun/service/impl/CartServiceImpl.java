package com.tencent.wxcloudrun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tencent.wxcloudrun.dao.CartMapper;
import com.tencent.wxcloudrun.model.Cart;
import com.tencent.wxcloudrun.service.CartService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
    
    @Override
    public List<Cart> getUserCart(Integer userId) {
        LambdaQueryWrapper<Cart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Cart::getUserId, userId);
        return list(queryWrapper);
    }
    
    @Override
    public boolean updateQuantity(Integer cartId, Integer quantity) {
        Cart cart = new Cart();
        cart.setCartId(cartId);
        cart.setQuantity(quantity);
        return updateById(cart);
    }
    
    @Override
    public boolean clearUserCart(Integer userId) {
        LambdaQueryWrapper<Cart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Cart::getUserId, userId);
        return remove(queryWrapper);
    }
} 
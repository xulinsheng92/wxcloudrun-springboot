package com.tencent.wxcloudrun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tencent.wxcloudrun.dao.OrderMapper;
import com.tencent.wxcloudrun.model.Order;
import com.tencent.wxcloudrun.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    
    @Override
    @Transactional
    public Order createOrder(Integer userId) {
        Order order = new Order();
        order.setUserId(userId);
        order.setOrderStatus("待付款");
        save(order);
        return order;
    }
    
    @Override
    public List<Order> getUserOrders(Integer userId) {
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Order::getUserId, userId)
                   .orderByDesc(Order::getCreatedAt);
        return list(queryWrapper);
    }
    
    @Override
    public boolean updateOrderStatus(Integer orderId, String status) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderStatus(status);
        return updateById(order);
    }
} 
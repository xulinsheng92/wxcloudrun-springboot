package com.tencent.wxcloudrun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tencent.wxcloudrun.model.Order;
import java.util.List;

public interface OrderService extends IService<Order> {
    // 创建订单
    Order createOrder(Integer userId);
    
    // 获取用户的所有订单
    List<Order> getUserOrders(Integer userId);
    
    // 更新订单状态
    boolean updateOrderStatus(Integer orderId, String status);
} 
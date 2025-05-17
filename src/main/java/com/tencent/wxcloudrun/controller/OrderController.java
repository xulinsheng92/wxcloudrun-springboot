package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Order;
import com.tencent.wxcloudrun.model.response.ApiResponse;
import com.tencent.wxcloudrun.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 订单管理控制器
 * 处理订单相关的HTTP请求，包括创建、查询和更新订单状态
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 为指定用户创建新订单
     * @param userId 用户ID
     * @return 创建的订单信息
     */
    @PostMapping("/user/{userId}")
    public ApiResponse<Order> createOrder(@PathVariable Integer userId) {
        return ApiResponse.success(orderService.createOrder(userId));
    }

    /**
     * 获取用户的所有订单
     * @param userId 用户ID
     * @return 订单列表
     */
    @GetMapping("/user/{userId}")
    public ApiResponse<List<Order>> getUserOrders(@PathVariable Integer userId) {
        return ApiResponse.success(orderService.getUserOrders(userId));
    }

    /**
     * 根据ID获取订单信息
     * @param id 订单ID
     * @return 订单信息
     */
    @GetMapping("/{id}")
    public ApiResponse<Order> getById(@PathVariable Integer id) {
        return ApiResponse.success(orderService.getById(id));
    }

    /**
     * 更新订单状态
     * @param id 订单ID
     * @param status 新的订单状态
     * @return 更新结果
     */
    @PutMapping("/{id}/status")
    public ApiResponse<Boolean> updateStatus(@PathVariable Integer id, @RequestParam String status) {
        return ApiResponse.success(orderService.updateOrderStatus(id, status));
    }
} 
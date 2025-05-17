package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Order;
import com.tencent.wxcloudrun.model.response.ApiResponse;
import com.tencent.wxcloudrun.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/user/{userId}")
    public ApiResponse<Order> createOrder(@PathVariable Integer userId) {
        return ApiResponse.success(orderService.createOrder(userId));
    }

    @GetMapping("/user/{userId}")
    public ApiResponse<List<Order>> getUserOrders(@PathVariable Integer userId) {
        return ApiResponse.success(orderService.getUserOrders(userId));
    }

    @GetMapping("/{id}")
    public ApiResponse<Order> getById(@PathVariable Integer id) {
        return ApiResponse.success(orderService.getById(id));
    }

    @PutMapping("/{id}/status")
    public ApiResponse<Boolean> updateStatus(@PathVariable Integer id, @RequestParam String status) {
        return ApiResponse.success(orderService.updateOrderStatus(id, status));
    }
} 
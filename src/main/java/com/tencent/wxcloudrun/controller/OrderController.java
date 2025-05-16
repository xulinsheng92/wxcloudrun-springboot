package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Order;
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
    public Order createOrder(@PathVariable Integer userId) {
        return orderService.createOrder(userId);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getUserOrders(@PathVariable Integer userId) {
        return orderService.getUserOrders(userId);
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Integer id) {
        return orderService.getById(id);
    }

    @PutMapping("/{id}/status")
    public boolean updateStatus(@PathVariable Integer id, @RequestParam String status) {
        return orderService.updateOrderStatus(id, status);
    }
} 
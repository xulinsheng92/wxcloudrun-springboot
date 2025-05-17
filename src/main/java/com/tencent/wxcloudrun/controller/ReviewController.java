package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Review;
import com.tencent.wxcloudrun.model.response.ApiResponse;
import com.tencent.wxcloudrun.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 评价管理控制器
 * 处理评价相关的HTTP请求，包括创建、查询订单评价
 */
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    /**
     * 获取订单详情的所有评价
     * @param orderDetailId 订单详情ID
     * @return 评价列表
     */
    @GetMapping("/order-detail/{orderDetailId}")
    public ApiResponse<List<Review>> getOrderDetailReviews(@PathVariable Integer orderDetailId) {
        return ApiResponse.success(reviewService.getOrderDetailReviews(orderDetailId));
    }

    /**
     * 获取用户的所有评价
     * @param userId 用户ID
     * @return 评价列表
     */
    @GetMapping("/user/{userId}")
    public ApiResponse<List<Review>> getUserReviews(@PathVariable Integer userId) {
        return ApiResponse.success(reviewService.getUserReviews(userId));
    }

    /**
     * 创建新的评价
     * @param review 评价信息
     * @return 创建结果
     */
    @PostMapping
    public ApiResponse<Boolean> createReview(@RequestBody Review review) {
        return ApiResponse.success(reviewService.createReview(review));
    }

    /**
     * 根据ID获取评价信息
     * @param id 评价ID
     * @return 评价信息
     */
    @GetMapping("/{id}")
    public ApiResponse<Review> getById(@PathVariable Integer id) {
        return ApiResponse.success(reviewService.getById(id));
    }
} 
package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Review;
import com.tencent.wxcloudrun.model.response.ApiResponse;
import com.tencent.wxcloudrun.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/order-detail/{orderDetailId}")
    public ApiResponse<List<Review>> getOrderDetailReviews(@PathVariable Integer orderDetailId) {
        return ApiResponse.success(reviewService.getOrderDetailReviews(orderDetailId));
    }

    @GetMapping("/user/{userId}")
    public ApiResponse<List<Review>> getUserReviews(@PathVariable Integer userId) {
        return ApiResponse.success(reviewService.getUserReviews(userId));
    }

    @PostMapping
    public ApiResponse<Boolean> createReview(@RequestBody Review review) {
        return ApiResponse.success(reviewService.createReview(review));
    }

    @GetMapping("/{id}")
    public ApiResponse<Review> getById(@PathVariable Integer id) {
        return ApiResponse.success(reviewService.getById(id));
    }
} 
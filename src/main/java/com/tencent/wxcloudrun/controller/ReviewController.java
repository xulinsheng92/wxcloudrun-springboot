package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Review;
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
    public List<Review> getOrderDetailReviews(@PathVariable Integer orderDetailId) {
        return reviewService.getOrderDetailReviews(orderDetailId);
    }

    @GetMapping("/user/{userId}")
    public List<Review> getUserReviews(@PathVariable Integer userId) {
        return reviewService.getUserReviews(userId);
    }

    @PostMapping
    public boolean createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @GetMapping("/{id}")
    public Review getById(@PathVariable Integer id) {
        return reviewService.getById(id);
    }
} 
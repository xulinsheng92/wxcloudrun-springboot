package com.tencent.wxcloudrun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tencent.wxcloudrun.model.Review;
import java.util.List;

public interface ReviewService extends IService<Review> {
    // 获取订单详情的所有评价
    List<Review> getOrderDetailReviews(Integer orderDetailId);
    
    // 获取用户的所有评价
    List<Review> getUserReviews(Integer userId);
    
    // 创建评价
    boolean createReview(Review review);
} 
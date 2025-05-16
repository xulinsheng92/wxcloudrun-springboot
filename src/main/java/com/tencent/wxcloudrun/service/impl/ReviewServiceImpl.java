package com.tencent.wxcloudrun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tencent.wxcloudrun.dao.ReviewMapper;
import com.tencent.wxcloudrun.model.Review;
import com.tencent.wxcloudrun.service.ReviewService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review> implements ReviewService {
    
    @Override
    public List<Review> getOrderDetailReviews(Integer orderDetailId) {
        LambdaQueryWrapper<Review> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Review::getOrderDetailId, orderDetailId)
                   .orderByDesc(Review::getCreatedAt);
        return list(queryWrapper);
    }
    
    @Override
    public List<Review> getUserReviews(Integer userId) {
        LambdaQueryWrapper<Review> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Review::getUserId, userId)
                   .orderByDesc(Review::getCreatedAt);
        return list(queryWrapper);
    }
    
    @Override
    public boolean createReview(Review review) {
        return save(review);
    }
} 
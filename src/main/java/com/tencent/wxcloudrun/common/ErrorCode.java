package com.tencent.wxcloudrun.common;

import lombok.Getter;

@Getter
public enum ErrorCode {
    SUCCESS(200, "操作成功"),
    PARAM_ERROR(400, "请求参数错误"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "无权限访问"),
    NOT_FOUND(404, "资源不存在"),
    INTERNAL_ERROR(500, "服务器内部错误"),
    
    // 用户相关错误 1000-1999
    USER_NOT_FOUND(1000, "用户不存在"),
    USER_ALREADY_EXISTS(1001, "用户已存在"),
    
    // 菜品相关错误 2000-2999
    DISH_NOT_FOUND(2000, "菜品不存在"),
    DISH_NOT_AVAILABLE(2001, "菜品已下架"),
    
    // 购物车相关错误 3000-3999
    CART_EMPTY(3000, "购物车为空"),
    CART_ITEM_NOT_FOUND(3001, "购物车商品不存在"),
    
    // 订单相关错误 4000-4999
    ORDER_NOT_FOUND(4000, "订单不存在"),
    ORDER_STATUS_ERROR(4001, "订单状态错误"),
    
    // 评价相关错误 5000-5999
    REVIEW_NOT_FOUND(5000, "评价不存在"),
    REVIEW_ALREADY_EXISTS(5001, "该订单已评价");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
} 
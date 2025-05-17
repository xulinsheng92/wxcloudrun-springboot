package com.tencent.wxcloudrun.config;

import com.tencent.wxcloudrun.common.BusinessException;
import com.tencent.wxcloudrun.common.ErrorCode;
import com.tencent.wxcloudrun.model.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ApiResponse<?> handleBusinessException(BusinessException e) {
        log.error("业务异常：{}", e.getMessage());
        return ApiResponse.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<?> handleValidationException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder message = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            message.append(fieldError.getField())
                   .append(": ")
                   .append(fieldError.getDefaultMessage())
                   .append("; ");
        }
        log.error("参数校验异常：{}", message.toString());
        return ApiResponse.error(ErrorCode.PARAM_ERROR.getCode(), message.toString());
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<?> handleException(Exception e) {
        log.error("系统异常：", e);
        return ApiResponse.error(ErrorCode.INTERNAL_ERROR.getCode(), "系统异常，请联系管理员");
    }
} 
package com.shura.common.framework.vo;

import cn.hutool.core.lang.Assert;
import com.alibaba.fastjson.annotation.JSONField;
import com.shura.common.framework.exception.GlobalException;
import com.shura.common.framework.exception.BusinessException;
import com.shura.common.framework.exception.enums.GlobalErrorCodeConstants;

import java.io.Serializable;

/**
 * @Author Garvey
 * @Created 2022/1/22
 * @Description 通用返回对象
 */
public final class CommonResult<T> implements Serializable {

    /**
     * 提示码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 错误明细，内部调试使用
     */
    private String detailMessage;

    /**
     * 返回数据
     */
    private T data;

    public static <T> CommonResult<T> error(CommonResult<?> result) {
        return error(result.getCode(), result.getMessage(), result.getDetailMessage());
    }

    public static <T> CommonResult<T> error(BusinessException ex) {
        return error(ex.getCode(), ex.getMessage(), ex.getDetailMessage());
    }

    public static <T> CommonResult<T> error(GlobalException ex) {
        return error(ex.getCode(), ex.getMessage(), ex.getDetailMessage());
    }

    public static <T> CommonResult<T> error(Integer code, String message) {
        return error(code, message, null);
    }

    public static <T> CommonResult<T> error(Integer code, String message, String detailMessage) {
        Assert.isTrue(!GlobalErrorCodeConstants.SUCCESS.getCode().equals(code), "非法错误码！");

        CommonResult<T> result = new CommonResult<>();
        result.code = code;
        result.message = message;
        result.detailMessage = detailMessage;
        return result;
    }

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.code = GlobalErrorCodeConstants.SUCCESS.getCode();
        result.data = data;
        result.message = GlobalErrorCodeConstants.SUCCESS.getMessage();
        return result;
    }

    /**
     * 判断是否有异常。有，则抛出
     * @throws GlobalException
     * @throws BusinessException
     */
    public void checkError() throws GlobalException, BusinessException {
        if (isSuccess()) {
            return;
        }

        // 全局异常
        if (GlobalErrorCodeConstants.isMatch(code)) {
            throw new GlobalException(code, message).setDetailMessage(detailMessage);
        }

        // 业务异常
        throw new BusinessException(code, message).setDetailMessage(detailMessage);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public CommonResult<T> setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @JSONField(serialize = false)
    public boolean isSuccess() {
        return GlobalErrorCodeConstants.SUCCESS.getCode().equals(this.code);
    }

    @JSONField(serialize = false)
    public boolean isError() {
        return !isSuccess();
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", detailMessage='" + detailMessage + '\'' +
                ", data=" + data +
                '}';
    }
}

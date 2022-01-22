package com.shura.common.framework.exception;

/**
 * @Author Garvey
 * @Created 2022/1/22
 * @Description 业务异常
 */
public final class BusinessException extends RuntimeException {

    /**
     * 业务错误码
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String message;

    /**
     * 详细错误信息，内部调试使用
     */
    private String detailMessage;

    public BusinessException() {}

    public BusinessException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public BusinessException setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
        return this;
    }
}

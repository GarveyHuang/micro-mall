package com.shura.common.framework.exception;

/**
 * @Author Garvey
 * @Created 2022/1/22
 * @Description 错误码对象
 *
 * 全局错误码，占用 [0, 999]，参见 {@link GlobalException}
 * 业务异常错误码，占用 [1 000 000 000, +∞)
 */
public class ErrorCode {

    /**
     * 错误码
     */
    private final Integer code;
    /**
     * 错误提示
     */
    private final String message;

    public ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

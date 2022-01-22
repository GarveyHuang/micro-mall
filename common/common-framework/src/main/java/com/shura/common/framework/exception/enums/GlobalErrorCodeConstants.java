package com.shura.common.framework.exception.enums;

import com.shura.common.framework.exception.ErrorCode;

/**
 * @Author Garvey
 * @Created 2022/1/22
 * @Description 全局错误码枚举
 *
 * 0-999 系统异常编码保留
 */
public interface GlobalErrorCodeConstants {

    ErrorCode SUCCESS = new ErrorCode(200, "成功");

    // ========== 客户端错误 ==========
    ErrorCode BAD_REQUEST = new ErrorCode(400, "参数不正确");
    ErrorCode UNAUTHORIZED = new ErrorCode(401, "账号未登录");
    ErrorCode FORBIDDEN = new ErrorCode(403, "没有该操作权限");
    ErrorCode NOT_FOUND = new ErrorCode(404, "未找到请求");
    ErrorCode METHOD_NOT_ALLOWED = new ErrorCode(405, "不支持的请求方法");

    // ========== 服务端错误 ==========
    ErrorCode INTERNAL_SERVER_ERROR = new ErrorCode(500, "系统异常");

    ErrorCode UNKNOWN = new ErrorCode(999, "未知错误");

    static boolean isMatch(Integer code) {
        return code != null
                && code >= SUCCESS.getCode()
                && code <= UNKNOWN.getCode();
    }
}

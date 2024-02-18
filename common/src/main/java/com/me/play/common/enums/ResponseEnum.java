package com.me.play.common.enums;

/**
 * ResponseEnum
 * 错误信息枚举
 *
 * @author xunnongchao
 * @since 2024/2/6
 */
public enum ResponseEnum {

    OK(0, "成功"),
    ERROR(-1, "内部异常，请稍后再试"),
    ERROR_PARAM(400, "未传值或值类型错误"),
    PERMISSION_DENIED(103, "权限不足"),
    NOT_FOUND(404, "未匹配资源"),
    ;
    private final int code;
    private final String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

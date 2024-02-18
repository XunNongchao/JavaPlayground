package com.me.play.common.utils;


import com.me.play.common.enums.ResponseEnum;


/**
 * 统一返回包装
 *
 * @author xunnongchao
 * @since 2023/10/13
 */
public record R<T>(
        int code,
        String msg,
        T object
) {
    public R(T data) {
        this(ResponseEnum.OK.getCode(), ResponseEnum.OK.getMsg(), data);
    }

    public static R<?> ok() {
        return new R<>(null);
    }

    public static <T> R<T> ok(T data) {
        return new R<>(data);
    }

    public static <T> R<T> ok(int code, String msg, T object) {
        return new R<>(code, msg, object);
    }

    public static R<?> error(ResponseEnum rEnum) {
        return new R<>(rEnum.getCode(), rEnum.getMsg(), null);
    }

    public static R<?> error() {
        return new R<>(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getMsg(), null);
    }

    public static R<?> error(String msg) {
        return new R<>(ResponseEnum.ERROR.getCode(), msg, null);
    }

    public static R<?> error(int code, String msg) {
        return new R<>(code, msg, null);
    }

    public static <T> R<T> error(int code, String msg, T object) {
        return new R<>(code, msg, object);
    }
}
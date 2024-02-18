package com.me.play.spring.boot.utils;

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
    public static final String OK_MSG = "OK";
    public static final int OK_CODE = 0;

    public static final String ERROR_MSG = "ERROR";
    public static final int ERROR_CODE = -1;

    public R(T data) {
        this(OK_CODE, OK_MSG, data);
    }

    public static R<?> ok() {
        return new R<>(null);
    }

    public static R ok(Object data) {
        return new R<>(data);
    }

    public static <T> R<T> ok(int code, String msg, T object) {
        return new R<>(code, msg, object);
    }

    public static R<?> error() {
        return new R<>(ERROR_CODE, ERROR_MSG, null);
    }

    public static R<?> error(String msg) {
        return new R<>(ERROR_CODE, msg, null);
    }

    public static R<?> error(int code, String msg) {
        return new R<>(code, msg, null);
    }

    public static <T> R<T> error(int code, String msg, T object) {
        return new R<>(code, msg, object);
    }
}
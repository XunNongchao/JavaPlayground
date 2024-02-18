package com.me.play.spring.boot.utils;

/**
 * PagedR
 * 带分页的返回值包装
 *
 * @author xunnongchao
 * @since 2024/2/5
 */
public record PagedR<T>(
        R<T> result,
        int currentPage,
        int pageSize,
        int total
) {
}

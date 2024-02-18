package com.me.play.todo.utils;

import com.me.play.common.utils.R;

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

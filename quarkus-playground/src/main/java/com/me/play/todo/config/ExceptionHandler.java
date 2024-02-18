package com.me.play.todo.config;

import com.me.play.common.utils.R;
import io.quarkus.logging.Log;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import static com.me.play.common.enums.ResponseEnum.*;


/**
 * ExceptionHandler
 * 全局异常拦截
 *
 * @author xunnongchao
 * @since 2024/2/6
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable throwable) {
        Log.error("拦截异常：e:{}", throwable, throwable);

        R<?> response = switch (throwable) {
            case NotFoundException notFound -> R.error(NOT_FOUND);
            case NullPointerException nullPointer -> R.error(ERROR);
            case IllegalArgumentException illArgument -> R.error(ERROR_PARAM);
            case IllegalAccessError illAccess -> R.error(PERMISSION_DENIED);
            default -> R.error();
        };

        return Response.status(Response.Status.OK)
                .entity(response)
                .build();
    }
}

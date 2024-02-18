package com.me.play.todo.config;

import com.me.play.common.utils.R;
import io.quarkus.hibernate.validator.runtime.jaxrs.ViolationReport;
import io.quarkus.logging.Log;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GlobalResponseFilter
 * 全局返回值包装
 *
 * @author xunnongchao
 * @since 2024/2/6
 */
@Provider
public class GlobalResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext request,
                       ContainerResponseContext response) throws IOException {
        Log.info("【全局返回值包装】");

        if (isFileResponse(response.getMediaType())) {
            return;
        }

        switch (response.getEntity()) {
            case ViolationReport report -> setEntityWithViolationReport(response, report);
            case R<?> r -> setEntityWithJsonType(response, r);
            case null, default -> setEntityWithJsonType(response, R.ok(response.getEntity()));
        }

    }

    /**
     * 未通过validator校验的情况，将校验结果包装到标准返回中
     *
     * @param response 响应上下文
     * @param report   校验报告
     */
    private void setEntityWithViolationReport(ContainerResponseContext response, ViolationReport report) {
        response.setEntity(
                R.error(report.getStatus(), getViolations(report.getViolations())),
                response.getEntityAnnotations(),
                MediaType.APPLICATION_JSON_TYPE
        );
    }

    /**
     * 转换成字符串
     *
     * @param violations 校验消息列表
     * @return 拼接后的结果
     */
    private String getViolations(List<ViolationReport.Violation> violations) {
        return violations.stream()
                .map(ViolationReport.Violation::toString)
                .collect(Collectors.joining(","));
    }

    /**
     * 检测是否是文件或二进制类型的返回
     *
     * @param mediaType 媒体类型
     * @return true是，false否
     */
    private boolean isFileResponse(MediaType mediaType) {
        return mediaType != null
                && (
                mediaType.equals(MediaType.APPLICATION_OCTET_STREAM_TYPE)
                        || mediaType.getSubtype().toLowerCase().endsWith("pdf")
                        || mediaType.getSubtype().toLowerCase().endsWith("zip")
        );
    }

    /**
     * 设置json格式的响应体
     *
     * @param response 响应上下文
     * @param r        返回内容
     */
    private void setEntityWithJsonType(ContainerResponseContext response, R<?> r) {
        // 检查原始状态码，如果是204且实体不为null，则更改为200
        if (response.getStatus() == Response.Status.NO_CONTENT.getStatusCode() && r != null) {
            response.setStatusInfo(Response.Status.OK);
        }
        response.setEntity(r,
                response.getEntityAnnotations(),
                MediaType.APPLICATION_JSON_TYPE);
    }
}

package com.me.play.spring.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ThreadPoolConfig
 *
 * @author xunnongchao
 * @since 2024/2/5
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "pool.thread")
public class ThreadPoolParamConfig {
    /**
     * 线程池前缀名
     */
    private String threadNamePrefix;
    /**
     * 核心线程数
     */
    private Integer coreSize;
    /**
     * 最大线程数
     */
    private Integer maxSize;
    /**
     * 线程池队列大小
     */
    private Integer queueCapacity;
    /**
     * 线程池存活时间（单位：秒）
     */
    private Integer keepAlive;
}

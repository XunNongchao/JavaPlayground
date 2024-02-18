package com.me.play.spring.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadPoolConfig
 *
 * @author xunnongchao
 * @since 2024/2/6
 */
@Configuration
public class ThreadPoolConfig {

    @Bean
    public ExecutorService pool() {
        return Executors.newVirtualThreadPerTaskExecutor();
    }
}

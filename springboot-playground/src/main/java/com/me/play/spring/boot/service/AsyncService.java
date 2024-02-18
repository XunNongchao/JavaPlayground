package com.me.play.spring.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

/**
 * AsyncService
 *
 * @author xunnongchao
 * @since 2024/2/6
 */
@Slf4j
@Service
public class AsyncService {

    @Async
    public void testAsync(CountDownLatch latch) {
        try {
            log.info("Async start: {}", Thread.currentThread().getName());
            Thread.sleep(1000);
            log.info("Async over: {}", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            latch.countDown();
        }
    }
}

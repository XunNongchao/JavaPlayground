package com.me.play.spring.boot.controller;

import com.me.play.spring.boot.service.AsyncService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * MainController
 *
 * @author xunnongchao
 * @since 2024/2/6
 */
@Slf4j
@RestController
public class MainController {

    private final AsyncService service;
    private final ExecutorService pool;

    public MainController(AsyncService service,
                          ExecutorService pool) {
        this.service = service;
        this.pool = pool;
    }

    @SneakyThrows
    @Transactional
    @GetMapping("testAsync")
    public void testAsync() {
        log.info("Main start: {}", Thread.currentThread().getName());
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            service.testAsync(latch);
        }
        latch.await();
        log.info("Main over: {}", Thread.currentThread().getName());
    }

    public void testPool() {
        pool.execute(() -> {

        });
    }
}

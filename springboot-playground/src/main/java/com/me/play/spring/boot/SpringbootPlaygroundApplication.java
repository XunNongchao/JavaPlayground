package com.me.play.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class SpringbootPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPlaygroundApplication.class, args);
    }

}

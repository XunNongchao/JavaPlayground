package com.me.play;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithName;

@ConfigMapping(prefix = "greeting")
public interface GreetingConfig {

    @WithDefault("hello")
    @WithName("message")
    String message();

}
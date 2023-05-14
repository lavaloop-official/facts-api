package com.lavaloop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.lavaloop.web",
        "com.lavaloop.common",
        "com.lavaloop.persistance",
        "com.lavaloop.remoteApi"
})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

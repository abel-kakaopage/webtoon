package com.kakao.webtoon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class WebtoonApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebtoonApplication.class, args);
    }

}

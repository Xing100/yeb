package com.xxxx.server;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//@EnableWebSecurity(debug = true)
@SpringBootApplication
@MapperScan("com.xxxx.server.mapper")
@EnableScheduling
public class YebApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(YebApplication.class, args);



    }
}

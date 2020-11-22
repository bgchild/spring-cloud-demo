package com.lk.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LkEurekabApplication {

    public static void main(String[] args) {
        SpringApplication.run(LkEurekabApplication.class, args);
    }

}

package io.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages= "io.microservice")
@EnableDiscoveryClient
public class LimitsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LimitsServiceApplication.class, args);
    }
}
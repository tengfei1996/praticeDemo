package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.example.demo.*"})
@ComponentScan(basePackages = {"com.example.demo.*"})
public class VuedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VuedemoApplication.class, args);
    }

}

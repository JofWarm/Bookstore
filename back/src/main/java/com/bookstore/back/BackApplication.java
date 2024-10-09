package com.bookstore.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.bookstore.back")
public class BackApplication {

    public static void main(String[] args) {

        SpringApplication.run(BackApplication.class, args);
    }

}

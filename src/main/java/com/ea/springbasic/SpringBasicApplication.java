package com.ea.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * It is required to have a class annotated with @SpringBootApplication and a main method to keep
 * tests working, because the Spring Boot framework requires a main entry point to start the application context.
 * <p>
 *  When you annotate a class with @SpringBootApplication,
 *  it serves as the entry point for your Spring Boot application.
 *  The @SpringBootApplication annotation combines three other annotations:
 *  {@code @Configuration,} @EnableAutoConfiguration, and @ComponentScan.
 */
@SpringBootApplication
public class SpringBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBasicApplication.class, args);
    }
}

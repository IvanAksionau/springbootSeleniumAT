package com.ea.springbasic.steps;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * This class is used to configure Cucumber with Spring Boot.
 * <p>
 * The @CucumberContextConfiguration annotation is used to load the Spring Boot application context.
 * The @SpringBootTest annotation is used to load the application configuration.
 */
@CucumberContextConfiguration
@SpringBootTest
public class CucumberTestContextConfig {
}

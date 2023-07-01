package com.ea.springbasic.steps;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;

/**
 * This class is used to configure Cucumber with Spring Boot.
 * <p>
 * The @CucumberContextConfiguration annotation is used to load the Spring Boot application context.
 * The @SpringBootTest annotation is used to load the application configuration.
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@CucumberContextConfiguration
@SpringBootTest
public class CucumberTestContextConfig {
}

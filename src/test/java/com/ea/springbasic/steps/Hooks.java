package com.ea.springbasic.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * This class should contain methods annotated with
 * Cucumber's {@link Before} and {@link After} annotations.
 * These methods will be executed before and after each scenario.
 */
public class Hooks {

    @Autowired
    private WebDriver webDriver;

    @Value("${app.url}")
    private String appUrl;

    @Before
    public void setup(Scenario scenario) {
        webDriver.navigate().to(appUrl);
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        webDriver.quit();
    }
}

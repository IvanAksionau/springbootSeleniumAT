package com.ea.springbasic.steps;

import com.ea.springbasic.util.ScreenShotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;

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

    @Lazy
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Before
    public void setup(Scenario scenario) {
        webDriver.navigate().to(appUrl);
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            screenShotUtil.takeScreenShot(scenario.getName());
        }
        webDriver.quit();
    }
}

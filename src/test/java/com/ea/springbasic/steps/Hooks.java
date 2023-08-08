package com.ea.springbasic.steps;

import com.ea.springbasic.models.TestUserDetails;
import com.ea.springbasic.models.UserDetails;
import com.ea.springbasic.pages.ComingSoonPage;
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

    @Value("${app.url}")
    private String appUrl;

    @Value("${user.email}")
    private String userEmail;

    @Value("${user.password}")
    private String userPassword;

    @Value("${app.system.password}")
    private String systemPassword;

    @Value("${app.env}")
    private String env;

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private ComingSoonPage comingSoonPage;

    @Lazy
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Autowired
    private TestUserDetails testUserDetails;

    @Before
    public void setup(Scenario scenario) {
        testUserDetails.setUserDetails(new UserDetails(userEmail, userPassword));
        webDriver.navigate().to(appUrl);
        webDriver.manage().window().maximize();
        if (env.equals("dev")) {
            comingSoonPage.clickActivatePasswordInput();
            comingSoonPage.login(systemPassword);
        }
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            screenShotUtil.takeScreenShot(scenario.getName());
        }
        webDriver.quit();
    }
}

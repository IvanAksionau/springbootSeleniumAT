package com.ea.springbasic.test;

import com.ea.springbasic.pages.MainPage2;
import com.ea.springbasic.util.ScreenShotUtil;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/*
  set 'spring.profiles.active=qa' in VM options/env variables of run configuration
 */
@SpringBootTest
public class SpringTestNGTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected WebDriver webDriver;

    @Value("${app.url}")
    private String appUrl;

    @Value("${implicit.wait.time}")
    public int implicitWaitTime ;

    @Autowired
    private MainPage2 mainPage2;

    @Lazy
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @BeforeMethod(alwaysRun = true)
    protected void setupWebDriver() {
        // Implicit Wait directs the Selenium WebDriver to wait for a certain measure of time
        // before throwing an exception.
        // Once this time is set, WebDriver will wait for the element before the exception occurs.
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
        webDriver.navigate().to(appUrl);
    }

    @BeforeTest(alwaysRun = true)
    @Override
    protected void springTestContextPrepareTestInstance() throws Exception {
        super.springTestContextPrepareTestInstance();
        System.out.println("Before class");
    }

    @Test
    public void test() {
        mainPage2.performLogin();
        mainPage2.isDisplayed();
        screenShotUtil.takeScreenShot();
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}

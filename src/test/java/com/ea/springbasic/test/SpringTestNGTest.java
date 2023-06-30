package com.ea.springbasic.test;

import com.ea.springbasic.pages.MainPage2;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

/*
  set 'spring.profiles.active=qa' in VM options/env variables of run configuration
 */
@SpringBootTest
public class SpringTestNGTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected WebDriver webDriver;

    @Value("${app.url}")
    private String appUrl;

    @Autowired
    private MainPage2 mainPage2;

    @BeforeMethod(alwaysRun = true)
    protected void setupWebDriver() {
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
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}

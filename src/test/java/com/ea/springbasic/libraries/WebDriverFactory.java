package com.ea.springbasic.libraries;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

/**
 * In this class we set up webdriver with possibility to run tests in parallel,
 * by using @Scope("driverScope") annotation, which creates a new instance of webdriver for each thread.
 * <p>
 * Also, to support parallel test execution we add @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) annotation
 * for all page object classes. See ex. {@link com.ea.springbasic.pages.HomePage} class.
 */
@Configuration
@Profile("!remote")
public class WebDriverFactory {

    @Bean
    @Scope("driverScope")
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    @Bean
    @Scope("driverScope")
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    WebDriver fireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.firefoxdriver().browserVersion("115.0").setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        return new FirefoxDriver(options);
    }
}

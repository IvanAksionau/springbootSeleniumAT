package com.ea.springbasic.libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import java.net.URL;

/**
 * In this Beans configuration we use {@code @ConditionalOnProperty(name = "browser", havingValue = "chrome")}
 * which will use set property, locate into predefined '.properties' file (ex. 'browser=chrome').
 * <p>
 * In order to specify which '.properties' file,
 * we are gonna to use, we specify properties file marker like {@code @Profile("remote")},
 * so 'application-remote.properties' will be selected by Spring framework for usage.
 */
@Configuration
@Profile("remote")
public class RemoteWebDriverFactory {

    @Value("${grid.url}")
    public URL gridUrl;

    @Bean
    @Scope("driverScope")
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    WebDriver remoteChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new RemoteWebDriver(gridUrl, options);
    }

    @Bean
    @Scope("driverScope")
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    WebDriver remoteFireFoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        return new RemoteWebDriver(gridUrl, options);
    }
}

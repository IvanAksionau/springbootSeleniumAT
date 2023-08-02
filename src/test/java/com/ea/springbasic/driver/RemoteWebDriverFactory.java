package com.ea.springbasic.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

import java.net.URL;
import java.time.Duration;
import java.util.List;

/**
 * In this Beans configuration we use {@code @ConditionalOnProperty(name = "browser", havingValue = "chrome")}
 * which will use set property, locate into predefined '.properties' file (ex. 'browser=chrome').
 * <p>
 * In order to specify which '.properties' file,
 * we specify properties file marker like {@code @Profile("remote")},
 * so 'application-remote.properties' will be selected by Spring framework for usage,
 * otherwise it avoids to initiate this configuration.
 */
@Lazy
@Configuration
@Profile("remote")
public class RemoteWebDriverFactory {

    @Value("${grid.url}")
    public URL gridUrl;

    @Bean
    @Scope("driverScope")
    WebDriverWait wait(WebDriver webDriver) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    @Bean
    @Scope("driverScope")
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    WebDriver remoteChromeDriver(@Value("${driver.options:--remote-allow-origins=*}")
                                 List<String> driverOptions) {
        ChromeOptions options = new ChromeOptions();
        driverOptions.forEach(options::addArguments);
        return new RemoteWebDriver(gridUrl, options);
    }

    @Bean
    @Scope("driverScope")
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    WebDriver remoteFireFoxDriver(@Value("${driver.options:--remote-allow-origins=*}")
                                  List<String> driverOptions) {
        FirefoxOptions options = new FirefoxOptions();
        driverOptions.forEach(options::addArguments);
        return new RemoteWebDriver(gridUrl, options);
    }
}

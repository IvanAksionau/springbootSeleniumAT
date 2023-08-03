package com.ea.springbasic.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.time.Duration;
import java.util.NoSuchElementException;

/**
 * In this class we set up web-driver waiters.
 */
@Lazy
@Configuration
public class WebDriverWaitFactory {

    @Value("${explicit.wait.time}")
    public int explicitWaitTime;

    @Value("${fluent.polling.time}")
    public int fluentPollingTime;

    @Bean
    WebDriverWait webDriverWait(WebDriver webDriver) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(explicitWaitTime));
    }

    @Bean
    Wait<WebDriver> fluentWait(WebDriver webDriver) {
        return new FluentWait<WebDriver>(webDriver)
                .withTimeout(Duration.ofSeconds(explicitWaitTime))
                .pollingEvery(Duration.ofSeconds(fluentPollingTime))
                .ignoring(NoSuchElementException.class);
    }
}

package com.ea.springbasic.libraries;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import java.util.List;

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

    @Value("${driver.options}")
    public List<String> driverOptions;

    @Bean
    @Scope("driverScope")
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    WebDriver chromeDriver(ChromeOptions chromeOptions) {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }

    @Bean
    @Scope("driverScope")
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    WebDriver fireFoxDriver(FirefoxOptions firefoxOptions) {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(firefoxOptions);
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        driverOptions.forEach(options::addArguments);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        return options;
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    FirefoxOptions firefoxOptions() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("javascript.enabled", true);
        FirefoxOptions options = new FirefoxOptions();
        driverOptions.forEach(options::addArguments);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        options.merge(capabilities);
        return options;
    }
}

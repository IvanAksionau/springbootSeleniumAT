package com.ea.springbasic.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

import java.time.Duration;
import java.util.List;

/**
 * In this class we set up webdriver with possibility to run tests in parallel,
 * by using @Scope("driverScope") annotation, which creates a new instance of webdriver for each thread.
 * <p>
 * Also, to support parallel test execution we add @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) annotation
 * for all page object classes. See ex. {@link com.ea.springbasic.pages.HomePage} class.
 */
@Lazy
@Configuration
@Profile("!remote")
public class WebDriverFactory {

    @Value("${driver.options:--remote-allow-origins=*}")
    public List<String> driverOptions;

    @Bean
    @Scope("driverScope")
    WebDriverWait wait(WebDriver webDriver) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

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

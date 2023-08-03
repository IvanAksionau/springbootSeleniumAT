package com.ea.springbasic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Field level dependency injection
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class MainPage2 extends BasePage {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private HomePage homePage;

    @Value("${app.url}")
    private String appUrl;

    public MainPage2 performLogin() {
        homePage.clickLogin();
        loginPage.login("admin", "password");
        System.out.println("Login:" + appUrl);
        return this;
    }

    @Override
    public boolean isDisplayed() {
        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver arg0) {
                System.out.println("Checking for the object!!");
                WebElement element = arg0.findElement(By.cssSelector(".btn-default"));
                if (element != null) {
                    System.out.println("A new dynamic object is found.");
                }
                return element;
            }
        };
        fluentWait.until(function);

        webDriverWait.until(ExpectedConditions.visibilityOf(loginPage.btnLogin));
        return webDriverWait.until((d) -> loginPage.isDisplayed());
    }
}

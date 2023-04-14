package com.ea.springbasic.pages;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
/**
 * Constructor level dependency injection
 */
@Component
/**
 * @ConditionalOnProperty(name = "env", havingValue = "qa") restrict creation
 * of beans for all environments except qa in case of 'spring.profiles.active=qa' is set
 */
@ConditionalOnProperty(name = "env", havingValue = "qa")
public class MainPage {

    private final LoginPage loginPage;
    private final HomePage homePage;

    @Value("${app.url}")
    private String appUrl;

    public MainPage(LoginPage loginPage, HomePage homePage) {
        this.loginPage = loginPage;
        this.homePage = homePage;
    }

    public void PerformLogin() {
        System.out.println("Login:" + appUrl);
    }
}

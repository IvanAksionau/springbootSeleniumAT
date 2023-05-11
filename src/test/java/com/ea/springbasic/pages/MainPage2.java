package com.ea.springbasic.pages;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Field level dependency injection
 */
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
}

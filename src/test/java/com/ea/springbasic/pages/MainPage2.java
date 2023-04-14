package com.ea.springbasic.pages;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * Field level dependency injection
 */
@Component
public class MainPage2 {

    @Autowired
    private LoginPage loginPage;
    @Autowired
    private HomePage homePage;

    @Value("${app.url}")
    private String appUrl;

    public void PerformLogin() {
        System.out.println("Login:" + appUrl);
    }
}

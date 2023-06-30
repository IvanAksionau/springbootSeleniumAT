package com.ea.springbasic.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BasePage {

    @Autowired
    protected WebDriver webDriver;

    @PostConstruct
    public void initElements() {
        PageFactory.initElements(webDriver, this);
    }

    public void closeBrowser() {
        webDriver.quit();
    }
}

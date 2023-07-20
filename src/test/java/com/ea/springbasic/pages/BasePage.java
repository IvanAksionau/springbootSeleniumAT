package com.ea.springbasic.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

public abstract class BasePage {

    @Autowired
    protected WebDriver webDriver;

    @Autowired
    protected WebDriverWait wait;

    @PostConstruct
    public void initElements() {
        PageFactory.initElements(webDriver, this);
    }

    public abstract boolean isDisplayed();
}

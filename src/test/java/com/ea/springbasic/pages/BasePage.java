package com.ea.springbasic.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public abstract class BasePage {

    private final String SCROLL_TO_ELEMENT_FUNCTION =
            "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});";

    @Autowired
    protected WebDriver webDriver;

    @Lazy
    @Autowired
    protected WebDriverWait webDriverWait;

    @Lazy
    @Autowired
    protected FluentWait<WebDriver> fluentWait;

    @PostConstruct
    public void initElements() {
        PageFactory.initElements(webDriver, this);
    }

    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript(SCROLL_TO_ELEMENT_FUNCTION, element);
    }

    public abstract boolean isDisplayed();
}

package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@Page
public class HomePage extends BasePage {

    @FindBy(id = "default_logo")
    private WebElement defaultLogo;

    @FindBy(xpath = "//a[@href='/account/login']")
    private WebElement loginAccountButton;

    @FindBy(xpath = "//a[@href='/collections/apparel']")
    private WebElement shopNowButton;

    public void clickLoginAccountButton() {
        loginAccountButton.click();
    }

    public void clickShopNowButton() {
        shopNowButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return webDriverWait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .until((d) -> defaultLogo.isEnabled());
    }
}

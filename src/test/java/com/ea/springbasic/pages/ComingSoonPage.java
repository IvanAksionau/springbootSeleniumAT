package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

@Page
public class ComingSoonPage extends BasePage {

    @FindBy(xpath = "//div[@id='shopify-section-main-password-header']//span")
    private WebElement enterUsingPasswordButton;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    public void clickActivatePasswordInput() {
        enterUsingPasswordButton.click();
    }

    public void login(String password) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.sendKeys(password);
        passwordInput.sendKeys(Keys.ENTER);
    }

    @Override
    public boolean isDisplayed() {
        return webDriverWait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .until((d) -> enterUsingPasswordButton.isEnabled());
    }
}
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

    @FindBy(xpath = "//button[contains(text(),'Accept all')]")
    private WebElement acceptCookiesButton;

    public void clickActivatePasswordInput() {
        enterUsingPasswordButton.click();
    }

    public void login(String password) {
        fluentWait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
        acceptCookiesButton.click();
        enterUsingPasswordButton.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.sendKeys(password);
        passwordInput.sendKeys(Keys.ENTER);
    }

    @Override
    public boolean isDisplayed() {
        return fluentWait.until((d) -> enterUsingPasswordButton.isEnabled());
    }
}

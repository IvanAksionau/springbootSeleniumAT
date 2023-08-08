package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

@Page
public class LoginPage extends BasePage {

    @FindBy(id = "CustomerEmail")
    private WebElement customerEmailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@class='login-tab']//*[@id='login']")
    private WebElement loginFormActivateLabel;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public void login(String email, String password) {
        customerEmailInput.sendKeys(email);
        this.passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        fluentWait.until((d) -> loginButton.getAttribute("aria-disabled").equals("false"));
        loginButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return webDriverWait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .until((d) -> loginFormActivateLabel.getAttribute("class").contains("active"));
    }
}

package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class LoginPage extends BasePage {

    @FindBy(id = "CustomerEmail")
    private WebElement customerEmailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@class='login-tab']//*[@id='login']")
    private WebElement loginFormActivateLabel;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button//span[@class='show']")
    private WebElement showButton;

    public void login(String email, String password) {
        customerEmailInput.sendKeys(email);
        this.passwordInput.sendKeys(password);
        fluentWait.until((d) -> submitButton.getAttribute("aria-disabled").equals("false"));
        showButton.click();
        submitButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return fluentWait.until((d) -> loginFormActivateLabel.getAttribute("class").contains("active"));
    }
}

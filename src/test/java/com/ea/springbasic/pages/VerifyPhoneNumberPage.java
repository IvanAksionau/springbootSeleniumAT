package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@Page
public class VerifyPhoneNumberPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class, 'not-verified')]//h2[contains(@class, 'title')]")
    private WebElement verifyPhoneNumberPageTitle;

    @FindBy(xpath = "//button[contains(text(), 'Send Code')]")
    private WebElement sendCodeButton;

    @FindBy(xpath = "//button[contains(text(), 'Verify')]")
    private WebElement verifyCodeButton;

    @FindBy(xpath = "//div[@class='otp-modal__code-input-fields']//input[@type='text']")
    private WebElement verifyCodeInput;

    public void clickSendCodeButton() {
        sendCodeButton.click();
    }
    public void typeVerifyCode(String code) {
        verifyCodeInput.sendKeys(code);
    }

    public void clickVerifyCodeButton() {
        verifyCodeButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return webDriverWait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .until((d) -> verifyPhoneNumberPageTitle.isEnabled());
    }
}

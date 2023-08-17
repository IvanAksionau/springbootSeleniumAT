package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Page
public class VerifyPhoneNumberPopupPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class, 'not-verified')]//h2[contains(@class, 'title')]")
    private WebElement verifyPhoneNumberPageTitle;

    @FindBy(xpath = "//button[contains(text(), 'Send Code')]")
    private WebElement sendCodeButton;

    @FindBy(xpath = "//button[contains(text(), 'Verify')]")
    private WebElement verifyCodeButton;

    @FindBy(xpath = "//div[@class='otp-modal__code-input-fields']//input[@type='text']")
    private WebElement verifyCodeInput;

    public void clickSendCodeButton() {
        fluentWait.until(ExpectedConditions.elementToBeClickable(sendCodeButton));
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
        fluentWait.ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(verifyPhoneNumberPageTitle));
        return verifyPhoneNumberPageTitle.isEnabled();
    }
}

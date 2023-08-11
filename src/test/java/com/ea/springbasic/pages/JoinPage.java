package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class JoinPage extends BasePage {

    @FindBy(xpath = "//div[@class='login-tab']//*[@id='Join']")
    private WebElement joinFormActivateLabel;

    @FindBy(id = "CustomerEmail")
    private WebElement customerEmailInput;

    @FindBy(id = "form-first_name")
    private WebElement firstNameInput;

    @FindBy(id = "form-last_name")
    private WebElement lastNameInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public void clickJoinFormActivateLabel() {
        joinFormActivateLabel.click();
    }

    public void submitJoinForm(String email, String firstName, String lastName, String password) {
        customerEmailInput.sendKeys(email);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        passwordInput.sendKeys(password);
        fluentWait.until((d) -> submitButton.getAttribute("aria-disabled").equals("false"));
        submitButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return fluentWait.until((d) -> joinFormActivateLabel.getAttribute("class").contains("active"));
    }
}

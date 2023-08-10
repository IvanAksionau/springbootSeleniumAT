package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@Page
public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'checkout ')]")
    private WebElement checkoutPageContent;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@placeholder='First name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@placeholder='Last name']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@placeholder='Address']")
    private WebElement addressInput;

    @FindBy(xpath = "//input[@placeholder='Phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//div[@data-address-field='city']")
    private WebElement cityDropDown;

    @FindBy(xpath = "//div[@aria-label='Telephone country code']")
    private WebElement countryCodeDropDown;

    @FindBy(id = "verify-phone-btn")
    private WebElement continueToDeliveryButton;

    public void fillInCheckOutForm(String email, String firstName, String lastName,
                                   String address, String city, String phoneCode, String phoneNumber) {
        emailInput.sendKeys(email);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        addressInput.sendKeys(address);
        cityDropDown.click();
        webDriver.findElement(
                By.xpath("//option[contains(text(),'" + city + "')]")).click();
        countryCodeDropDown.click();
        webDriver.findElement(
                By.xpath("//span[contains(text(),'" + phoneCode + "')]")).click();
        phoneInput.sendKeys(phoneNumber);
    }

    public void submitCheckOutForm() {
        continueToDeliveryButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return webDriverWait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .until((d) -> checkoutPageContent.isEnabled());
    }
}

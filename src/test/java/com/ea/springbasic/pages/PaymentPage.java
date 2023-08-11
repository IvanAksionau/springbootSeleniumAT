package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class PaymentPage extends BasePage {

    @FindBy(xpath = "//li[contains(@class, 'item--current')]/span")
    private WebElement deliveryPageActiveLabel;

    @FindBy(xpath = "//div[@data-gateway-name='credit_card']")
    private WebElement creditCardRadioButton;

    @FindBy(xpath = "//div[@data-gateway-name='manual']")
    private WebElement CODRadioButton;

    @FindBy(id = "continue_button")
    private WebElement submitOrderButton;

    public void clickCreditCardButton() {
        creditCardRadioButton.click();
    }

    public void clickCashOnDeliveryButton() {
        CODRadioButton.click();
    }

    public void clickSubmitOrderButtonButton() {
        submitOrderButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return fluentWait.until((d) -> deliveryPageActiveLabel.getText().contains("Payment"));
    }
}

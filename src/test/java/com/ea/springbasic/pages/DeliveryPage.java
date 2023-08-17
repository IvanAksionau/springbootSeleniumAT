package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class DeliveryPage extends BasePage {

    @FindBy(xpath = "//li[contains(@class, 'item--current')]/span")
    private WebElement deliveryPageActiveLabel;

    @FindBy(id = "continue_button")
    private WebElement continueToPaymentButton;

    public void clickContinueToPaymentButton() {
        continueToPaymentButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return fluentWait.until((d) -> deliveryPageActiveLabel.getText().contains("Delivery"));
    }
}

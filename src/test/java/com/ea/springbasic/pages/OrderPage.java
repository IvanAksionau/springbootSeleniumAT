package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class OrderPage extends BasePage {

    @FindBy(xpath = "//h3[contains(@class, 'order-number')]")
    private WebElement orderNumber;

    @Override
    public boolean isDisplayed() {
        return fluentWait.until((d) -> !orderNumber.getText().isEmpty());
    }
}

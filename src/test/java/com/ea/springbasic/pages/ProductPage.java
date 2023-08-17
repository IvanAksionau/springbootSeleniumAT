package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[@class='product__title']/h1")
    private WebElement productTitle;

    @FindBy(xpath = "//button[@name='add']")
    private WebElement addToBagButton;

    public String getProductTitle() {
        return productTitle.getText();
    }

    public void clickAddToBagButton() {
        addToBagButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return fluentWait.until((d) -> productTitle.isEnabled());
    }
}

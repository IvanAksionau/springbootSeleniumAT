package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

@Page
public class ProductSideBarPage extends BasePage {

    @FindBy(id = "mini-cart")
    private WebElement productMiniCartWindow;

    @FindBy(xpath = "//div[@class='button-container']//button[@type='submit']")
    private WebElement checkOutButton;

    @FindBy(xpath = "//div[@id='main-cart-items']//div[@class='cart-subtitle']")
    private List<WebElement> cartSubTitle;

    @FindBy(xpath = "//div[@class='product-content']//a")
    private List<WebElement> productTitle;

    public void clickCheckOutButton() {
        fluentWait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
        checkOutButton.click();
    }

    public List<String> getProductTitleList() {
        fluentWait.until((d) -> !productTitle.stream().findFirst().orElseThrow().getText().isEmpty());
        return productTitle.stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isDisplayed() {
        return fluentWait.until((d) -> productMiniCartWindow.isEnabled());
    }
}

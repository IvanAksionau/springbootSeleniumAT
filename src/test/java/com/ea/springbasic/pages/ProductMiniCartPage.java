package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Page
public class ProductMiniCartPage extends BasePage {

    @FindBy(id = "mini-cart")
    private WebElement productMiniCartWindow;

    @FindBy(xpath = "//div[@class='button-container']//button[@type='submit']")
    private WebElement checkOutButton;

    @FindBy(xpath = "//div[@class='product-content']//a")
    private List<WebElement> productTitle;

    public void clickCheckOutButton() {
        checkOutButton.click();
    }

    public List<String> getProductTitleList() {
        return productTitle.stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isDisplayed() {
        return webDriverWait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .until((d) -> productMiniCartWindow.isEnabled());
    }
}

package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@Page
public class ShopNowPage extends BasePage {

    @FindBy(id = "FacetFiltersForm")
    private WebElement facetFiltersForm;

    public void selectCardByName(String cardName) {
        WebElement element = webDriver.findElement(By.xpath("//a[contains(text(),'" + cardName + "')]/.."));
        scrollToElement(element);
        element.click();
    }

    @Override
    public boolean isDisplayed() {
        return webDriverWait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .until((d) -> facetFiltersForm.isEnabled());
    }
}

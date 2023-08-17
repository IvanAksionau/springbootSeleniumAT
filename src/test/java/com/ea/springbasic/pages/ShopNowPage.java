package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class ShopNowPage extends BasePage {

    @FindBy(id = "FacetFiltersForm")
    private WebElement facetFiltersForm;

    public void selectCardByName(String cardName) {
        WebElement element = webDriver.findElement(By.xpath(
                "//a[contains(text(),'" + cardName + "')]/ancestor::div[@class='card-wrapper']"));
        element.click();
    }

    @Override
    public boolean isDisplayed() {
        return fluentWait.until((d) -> facetFiltersForm.isEnabled());
    }
}

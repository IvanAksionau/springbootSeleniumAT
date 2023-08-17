package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class AccountPage extends BasePage {

    @FindBy(id = "AccountHeroImage")
    private WebElement accountWelcomeImage;

    @Override
    public boolean isDisplayed() {
        return fluentWait.until((d) -> accountWelcomeImage.isDisplayed());
    }
}

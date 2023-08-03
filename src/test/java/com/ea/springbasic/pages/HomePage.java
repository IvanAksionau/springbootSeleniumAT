package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Page
public class HomePage extends BasePage {

    @FindBy(how = How.LINK_TEXT, using = "Login")
    public WebElement lnkLogin;

    @FindBy(how = How.LINK_TEXT, using = "Employee List")
    public WebElement lnkEmployeeList;

    @FindBy(how = How.LINK_TEXT, using = "Employee Details")
    WebElement lnkEmployeeDetails;

    public LoginPage clickLogin() {
        lnkLogin.click();
        return new LoginPage();
    }

    public void clickEmployeeList() {
        lnkEmployeeList.click();
    }

    public boolean isEmployeeDetailsExist() {
        return lnkEmployeeDetails.isDisplayed();
    }

    @Override
    public boolean isDisplayed() {
        webDriverWait.until(ExpectedConditions.visibilityOf(lnkLogin));
        return webDriverWait.until((d) -> lnkLogin.isDisplayed());
    }
}

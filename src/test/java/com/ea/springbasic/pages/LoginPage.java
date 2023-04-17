package com.ea.springbasic.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class LoginPage extends BasePage {
    @FindBy(how = How.NAME, using = "UserName")
    public WebElement txtUserName;
    @FindBy(how = How.NAME, using = "Password")
    public WebElement txtPassword;
    @FindBy(how = How.CSS, using = "#loginLink")
    public WebElement btnLogin;

    public void login(String userName, String password) {
        btnLogin.click();
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
        System.out.println("UserName and password: " + userName + "---" + password);
    }

    public HomePage clickLogin() {
        System.out.println("Click login from login page");
        return new HomePage();
    }
}

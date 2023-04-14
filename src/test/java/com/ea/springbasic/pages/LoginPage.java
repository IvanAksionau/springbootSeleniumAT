package com.ea.springbasic.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {
    @FindBy(how = How.NAME, using = "UserName")
    public WebElement txtUserName;
    @FindBy(how = How.NAME, using = "Password")
    public WebElement txtPassword;
    @FindBy(how = How.CSS, using = ".btn-default")
    public WebElement btnLogin;

    public LoginPage() {
        System.out.println("In Login page");
    }

    public void Login(String userName, String password) {
        System.out.println("UserName and password: " + userName + "---" + password);
    }

    public HomePage ClickLogin() {
        System.out.println("Click login from login page");
        return new HomePage();
    }
}

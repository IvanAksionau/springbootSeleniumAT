package com.ea.springbasic.steps;

import com.ea.springbasic.models.TestUserDetails;
import com.ea.springbasic.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginSteps {

    @Autowired
    public LoginPage loginPage;

    @Autowired
    private TestUserDetails testUserDetails;

    @Then("I check the user login page is displayed")
    public void ICheckLoginPageIsDisplayed() {
        loginPage.isDisplayed();
    }

    @Given("I login with user credentials")
    public void iClickLoginInHomePage() {
        loginPage.login(testUserDetails.getUserDetails().username(),
                testUserDetails.getUserDetails().password());
        loginPage.clickLogin();
    }
}

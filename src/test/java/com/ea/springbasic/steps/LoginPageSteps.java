package com.ea.springbasic.steps;

import com.ea.springbasic.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPageSteps extends BasePageSteps {

    @Autowired
    private LoginPage loginPage;

    @Then("I check the user login page is displayed")
    public void iCheckLoginPageIsDisplayed() {
        loginPage.isDisplayed();
    }

    @When("I login with user credentials")
    public void iLoginWithUserCredentials() {
        loginPage.login(testUserDetails.getUserDetails().getUserEmail(),
                testUserDetails.getUserDetails().getUserPassword());
    }
}

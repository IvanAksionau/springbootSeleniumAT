package com.ea.springbasic.steps;

import com.ea.springbasic.models.TestUserDetails;
import com.ea.springbasic.models.UserDetails;
import com.ea.springbasic.pages.HomePage;
import com.ea.springbasic.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class LoginSteps {

    @Autowired
    public HomePage homePage;

    @Autowired
    public LoginPage loginPage;

    @Autowired
    private TestUserDetails testUserDetails;

    @Given("I click login in Home Page")
    public void iClickLoginInHomePage() {
        homePage.clickLogin();

        //Scenario scope
        testUserDetails.setUserDetails(new UserDetails("admin", "password"));
    }

    @And("I click login button")
    public void iClickLoginButton() {
        loginPage.clickLogin();
    }

    @Then("I should see the userform page")
    public void iShouldSeeTheUserFormPage() {
        Assert.assertTrue(homePage.isEmployeeDetailsExist());
    }
}

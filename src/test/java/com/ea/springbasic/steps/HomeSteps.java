package com.ea.springbasic.steps;

import com.ea.springbasic.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class HomeSteps {

    @Autowired
    private HomePage homePage;

    @And("I check the home page is displayed")
    public void iCheckHomePageIsDisplayed() {
        Assert.assertTrue(homePage.isDisplayed());
    }

    @When("I click login account button")
    public void iClickLoginAccountButton() {
        homePage.clickLoginAccountButton();
    }

//    @And("I check the home page is displayed")
//    public void iEnterTheFollowingForLogin(DataTable table) {
//        //var data = table.asList();
//        loginPage.login(testUserDetails.getUserDetails().username(),
//                testUserDetails.getUserDetails().password());
//    }
}
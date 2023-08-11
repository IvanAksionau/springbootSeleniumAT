package com.ea.springbasic.steps;

import com.ea.springbasic.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class HomePageSteps extends BasePageSteps {

    @Autowired
    private HomePage homePage;

    @And("I check the home page is displayed")
    public void iCheckHomePageIsDisplayed() {
        Assert.assertTrue(homePage.isDisplayed(), "Home page is displayed");
    }

    @When("I click login account button")
    public void iClickLoginAccountButton() {
        homePage.clickLoginAccountButton();
    }

    @When("I click shop now button")
    public void iClickShopNowButton() {
        homePage.clickShopNowButton();
    }

//    @And("I check the home page is displayed")
//    public void iEnterTheFollowingForLogin(DataTable table) {
//        //var data = table.asList();
//        loginPage.login(testUserDetails.getUserDetails().userEmail(),
//                testUserDetails.getUserDetails().password());
//    }
}
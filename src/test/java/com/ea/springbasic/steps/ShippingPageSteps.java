package com.ea.springbasic.steps;

import com.ea.springbasic.pages.ShippingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class ShippingPageSteps extends BasePageSteps {

    @Autowired
    private ShippingPage shippingPage;

    @And("I check the shippingPage is displayed")
    public void iCheckHomePageIsDisplayed() {
        Assert.assertTrue(shippingPage.isDisplayed());
    }

    @When("I fill the checkout form")
    public void iFillTheCheckoutForm() {
       shippingPage.fillInCheckOutForm(
               testUserDetails.getUserDetails().getUserEmail(),
               testUserDetails.getUserDetails().getFirstName(),
               testUserDetails.getUserDetails().getLastName(),
               testUserDetails.getUserDetails().getAddress(),
               testUserDetails.getUserDetails().getCity(),
               testUserDetails.getUserDetails().getPhoneCode(),
               testUserDetails.getUserDetails().getPhoneNumber());
    }

    @When("I submit the checkout form")
    public void iSubmitCheckOutForm() {
       shippingPage.submitCheckOutForm();
    }
}

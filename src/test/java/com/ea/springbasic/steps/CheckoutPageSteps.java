package com.ea.springbasic.steps;

import com.ea.springbasic.pages.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class CheckoutPageSteps extends BasePageSteps {

    @Autowired
    private CheckoutPage checkoutPage;

    @And("I check the checkoutPage is displayed")
    public void iCheckHomePageIsDisplayed() {
        Assert.assertTrue(checkoutPage.isDisplayed());
    }

    @When("I fill the checkout form")
    public void iFillTheCheckoutForm() {
       checkoutPage.fillInCheckOutForm(
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
       checkoutPage.submitCheckOutForm();
    }
}

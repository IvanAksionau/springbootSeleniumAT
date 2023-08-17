package com.ea.springbasic.steps;

import com.ea.springbasic.pages.DeliveryPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class DeliveryPageSteps extends BasePageSteps {

    @Autowired
    private DeliveryPage deliveryPage;

    @Then("I check the delivery page is displayed")
    public void iCheckHomePageIsDisplayed() {
        Assert.assertTrue(deliveryPage.isDisplayed(), "Delivery page is displayed");
    }

    @When("I click continue to payment button")
    public void iFillTheCheckoutForm() {
        deliveryPage.clickContinueToPaymentButton();
    }
}

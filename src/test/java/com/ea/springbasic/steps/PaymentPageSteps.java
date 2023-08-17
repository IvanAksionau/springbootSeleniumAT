package com.ea.springbasic.steps;

import com.ea.springbasic.pages.PaymentPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class PaymentPageSteps extends BasePageSteps {

    @Autowired
    private PaymentPage paymentPage;

    @Then("I check the paymentPage page is displayed")
    public void iCheckPaymentPageIsDisplayed() {
        Assert.assertTrue(paymentPage.isDisplayed(), "Payment page is displayed");
    }

    @When("I select cash on delivery payment method")
    public void iCheckHomePageIsDisplayed() {
        paymentPage.clickCashOnDeliveryButton();
    }

    @When("I click submit order button")
    public void iClickSubmitOrderButtonButton() {
        paymentPage.clickSubmitOrderButtonButton();
    }
}

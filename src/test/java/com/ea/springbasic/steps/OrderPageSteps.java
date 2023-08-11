package com.ea.springbasic.steps;

import com.ea.springbasic.pages.OrderPage;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class OrderPageSteps extends BasePageSteps {

    @Autowired
    private OrderPage orderPage;

    @Then("I check the order page is displayed")
    public void iCheckPaymentPageIsDisplayed() {
        Assert.assertTrue(orderPage.isDisplayed(), "Order page is displayed");
    }
}

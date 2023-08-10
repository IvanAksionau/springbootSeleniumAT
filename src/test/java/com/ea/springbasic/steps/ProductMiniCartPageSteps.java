package com.ea.springbasic.steps;

import com.ea.springbasic.pages.ProductMiniCartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class ProductMiniCartPageSteps {

    @Autowired
    private ProductMiniCartPage productMiniCartPage;

    @Then("I check the product mini cart page page is displayed for product {string}")
    public void iCheckProductMiniCartPageIsDisplayed(String productName) {
        Assert.assertTrue(
                productMiniCartPage.getProductTitleList().contains(productName));
    }

    @When("I click on the checkout button")
    public void IClickOnAddToBagButton() {
        productMiniCartPage.clickCheckOutButton();
    }
}

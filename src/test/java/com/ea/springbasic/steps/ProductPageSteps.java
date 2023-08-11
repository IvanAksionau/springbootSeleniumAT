package com.ea.springbasic.steps;

import com.ea.springbasic.pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class ProductPageSteps {

    @Autowired
    private ProductPage productPage;

    @Then("I check the product page is displayed for product {string}")
    public void ICheckProductPageIsDisplayedForProduct(String productName) {
        String productTitle = productPage.getProductTitle();
        Assert.assertEquals(productName, productTitle,
                "Product page is displayed for product '" + productName + "'\n");
    }

    @When("I click on the add to bag button")
    public void IClickOnAddToBagButton() {
        productPage.clickAddToBagButton();
    }
}

package com.ea.springbasic.steps;

import com.ea.springbasic.pages.ProductSideBarPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.List;

public class ProductMiniCartPageSteps {

    @Autowired
    private ProductSideBarPage productSideBarPage;

    @Then("I check the product side bar page is displayed for product {string}")
    public void iCheckProductSideBarPageIsDisplayed(String productName) {
        List<String> productTitleList = productSideBarPage.getProductTitleList();
        Assert.assertTrue(productTitleList.contains(productName),
                "Products side bar contain product '" + productName +"'\n");
    }

    @When("I click on the checkout button")
    public void IClickOnAddToBagButton() {
        productSideBarPage.clickCheckOutButton();
    }
}

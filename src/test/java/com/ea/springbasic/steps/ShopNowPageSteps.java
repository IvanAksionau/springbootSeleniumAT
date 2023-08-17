package com.ea.springbasic.steps;

import com.ea.springbasic.models.TestUserDetails;
import com.ea.springbasic.pages.JoinPage;
import com.ea.springbasic.pages.ShopNowPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class ShopNowPageSteps extends BasePageSteps {

    @Autowired
    private ShopNowPage shopNowPage;

    @Autowired
    private TestUserDetails testUserDetails;

    @When("I select card by name {string}")
    public void iSwitchToRegisterNewAccount(String cardName) {
        shopNowPage.selectCardByName(cardName);
    }

    @When("I check the shop now page is displayed")
    public void ICheckShopNowPageIsdDisplayed() {
        Assert.assertTrue(shopNowPage.isDisplayed(), "ShopNow page is displayed");
    }
}

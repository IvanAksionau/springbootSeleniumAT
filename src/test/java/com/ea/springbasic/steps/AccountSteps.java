package com.ea.springbasic.steps;

import com.ea.springbasic.pages.AccountPage;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountSteps {

    @Autowired
    private AccountPage accountPage;

    @Then("I check the user account page is displayed")
    public void iCheckHomePageIsDisplayed() {
        accountPage.isDisplayed();
    }
}
package com.ea.springbasic.steps;

import com.ea.springbasic.pages.JoinPage;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class JoinPageSteps extends BasePageSteps {

    @Autowired
    private JoinPage joinPage;

    @When("I open register new account page")
    public void iSwitchToRegisterNewAccount() {
        joinPage.clickJoinFormActivateLabel();
    }

    @When("I fill in and submit register new account form")
    public void iFillInAndSubmitNewAccountForm() {
        joinPage.submitJoinForm(testUserDetails.getUserDetails().getUserEmail(), testUserDetails.getUserDetails().getUserPassword(), testUserDetails.getUserDetails().getFirstName(), testUserDetails.getUserDetails().getLastName());
    }
}

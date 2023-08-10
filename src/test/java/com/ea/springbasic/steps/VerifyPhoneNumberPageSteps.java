package com.ea.springbasic.steps;

import com.ea.springbasic.models.TestUserDetails;
import com.ea.springbasic.pages.VerifyPhoneNumberPage;
import com.ea.springbasic.util.SMSReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class VerifyPhoneNumberPageSteps extends BasePageSteps {

    @Autowired
    private VerifyPhoneNumberPage verifyPhoneNumberPage;

    @Autowired
    private TestUserDetails testUserDetails;

    @Autowired
    private SMSReader smsReader;

    @Then("I check the phone number is not verified popup is displayed")
    public void ICheckPhoneNumberNotVerifiedIsdDisplayed() {
        verifyPhoneNumberPage.isDisplayed();
    }

    @When("I click send code button")
    public void iClickSendCodeButton() {
        verifyPhoneNumberPage.clickSendCodeButton();
    }

    @When("I type verify code value")
    public void iTypeVerifyCodeValue() {
        verifyPhoneNumberPage.typeVerifyCode(smsReader.extractVerificationCode());
    }

    @When("I click verify code button")
    public void iClickVerifyCodeButton() {
        verifyPhoneNumberPage.clickVerifyCodeButton();
    }
}

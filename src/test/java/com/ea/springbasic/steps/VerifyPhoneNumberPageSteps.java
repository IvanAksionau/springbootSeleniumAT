package com.ea.springbasic.steps;

import com.ea.springbasic.models.TestUserDetails;
import com.ea.springbasic.pages.VerifyPhoneNumberPopupPage;
import com.ea.springbasic.util.SMSReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class VerifyPhoneNumberPageSteps extends BasePageSteps {

    @Autowired
    private VerifyPhoneNumberPopupPage verifyPhoneNumberPopupPage;

    @Autowired
    private TestUserDetails testUserDetails;

    @Autowired
    private SMSReader smsReader;

    @Then("I check the phone number is not verified popup is displayed")
    public void ICheckPhoneNumberNotVerifiedIsdDisplayed() {
        Assert.assertTrue(verifyPhoneNumberPopupPage.isDisplayed(),
                "VerifyPhoneNumberPopup page is displayed");
    }

    @When("I click send code button")
    public void iClickSendCodeButton() {
        verifyPhoneNumberPopupPage.clickSendCodeButton();
    }

    @When("I type verify code value")
    public void iTypeVerifyCodeValue() {
        verifyPhoneNumberPopupPage.typeVerifyCode(smsReader.extractVerificationCode());
    }

    @When("I click verify code button")
    public void iClickVerifyCodeButton() {
        verifyPhoneNumberPopupPage.clickVerifyCodeButton();
        System.out.println("dsfds");
    }
}

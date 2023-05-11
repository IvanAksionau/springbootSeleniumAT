package com.ea.springbasic.steps;


import com.ea.springbasic.models.TestUserDetails;
import com.ea.springbasic.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeSteps {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private TestUserDetails testUserDetails;

    @And("I enter the following for Login")
    public void iEnterTheFollowingForLogin(DataTable table) {
        //var data = table.asList();
        loginPage.login(testUserDetails.getUserDetails().username(),
                testUserDetails.getUserDetails().password());
    }
}
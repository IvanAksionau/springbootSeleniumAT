package com.ea.springbasic.models;


import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

/**
 * Working with Scenario Scopes - Passing data from one-step definition to other.
 */
@Component
@ScenarioScope
public class TestUserDetails {

    private UserDetails userDetails;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}

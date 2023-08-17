package com.ea.springbasic.steps;

import com.ea.springbasic.models.TestUserDetails;
import org.springframework.beans.factory.annotation.Autowired;

public class BasePageSteps {

    @Autowired
    protected TestUserDetails testUserDetails;
}

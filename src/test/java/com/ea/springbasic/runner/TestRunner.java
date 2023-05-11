package com.ea.springbasic.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/com/ea/springbasic/features"}, glue = "com.ea.springbasic.steps")
public class TestRunner extends AbstractTestNGCucumberTests {
}

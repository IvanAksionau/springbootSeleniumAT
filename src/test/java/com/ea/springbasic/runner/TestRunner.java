package com.ea.springbasic.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * In your Cucumber runner class, you need to specify the location of your hook class.
 * This can be done by using the glue attribute of the {@link CucumberOptions} annotation.
 * {@code @DataProvider(parallel = true)} annotation is used to run tests in parallel.
 */
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json"},
        glue = "com.ea.springbasic.steps")
public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

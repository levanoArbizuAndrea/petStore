package com.brooker.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"json:target/build/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"com.brooker.stepdefinitions"},
        tags = "@PutPetStore "

)
public class RunnerTest {

    @BeforeClass
    public static void beforeAll() {
        Logger.getLogger(RunnerTest.class.getName()).info("Before all execution >>>");
    }

    @AfterClass
    public static void afterAll() {
        Logger.getLogger(RunnerTest.class.getName()).info("After all execution >>>");
    }
}

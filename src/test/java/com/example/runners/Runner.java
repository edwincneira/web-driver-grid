package com.example.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@tests",
        monochrome = true,
        features = {
                "src/test/resources/features/navegators.feature"
        },
        glue = "com.example")
public class Runner {
}

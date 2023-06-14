package com.example.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@tests",
        monochrome = true,
        features = {
                "src/test/resources/features/chromeNavegators.feature",
                "src/test/resources/features/edgeNavegators.feature",
                "src/test/resources/features/fireFixNvegators.feature"
        },
        glue = "com.example")
public class Runner {
}

package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/default-html-repotrs",
                "rerun:target/rerun.txt"},
        features ="src/test/resources/features/",
        glue = "com/zerobank/step_definitions",
        dryRun = false,
        tags ="@test"
)

public class CukesRunner {

}

package com.moduleOne;

import com.framework.ParentScenario;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber_json_reports/home-page.json",
                "json:target/cucumber.json",
                "html:target/home-page-html"},
        features = {"src/test/resources/features"},
        glue = {},
        tags = "")

public class AppTestRun extends ParentScenario {
    //Initialize pages


}

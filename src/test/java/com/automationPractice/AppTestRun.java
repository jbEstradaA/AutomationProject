package com.automationPractice;

import com.automationPractice.pages.ContactUsPage;
import com.automationPractice.pages.MainPage;
import com.framework.ParentScenario;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber_json_reports/home-page.json",
                "json:target/cucumber.json",
                "html:target/home-page-html"},
        features = {"src/test/resources/features/automationPractice"},
        glue = {"com.automationPractice.steps"},
        tags = "@tag")

public class AppTestRun extends ParentScenario {
    //Initialize pages
    protected static MainPage mainPage;
    protected static ContactUsPage contactUsPage;

    @Override
    public void initPages(RemoteWebDriver webDriver){
        mainPage = new MainPage(webDriver);
        contactUsPage = new ContactUsPage(webDriver);
    }

}

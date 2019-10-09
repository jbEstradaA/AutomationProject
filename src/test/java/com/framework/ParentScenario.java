package com.framework;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class ParentScenario extends AbstractTestNGCucumberTests {
    static private RemoteWebDriver webDriver;

    /**
     * This method is for initialize the browser depending by the value of the param
     * @param browser
     */
    @BeforeClass
    @Parameters({"browser"})
    public void startBrowser(String browser){
        switch (browser){
            case "chrome":
                startChrome();
                break;
            case "firefox":
                startFirefox();
                break;
            case "ie":
                break;
        }
    }

    /**
     * This method is for create an instance for all the pages required per module
     * @param webDriver
     */
    public abstract void initPages(RemoteWebDriver webDriver);

    /**
     * This is for initialize Chrome driver using io.github.bonigarcia libraries
     * @return RemoteWebDriver
     */
    public RemoteWebDriver startChrome(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        try {
            WebDriverManager.chromedriver().version("77.0").setup();
            webDriver = new ChromeDriver(options);
            webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            //Initialize pages
            initPages(webDriver);
        }catch (Exception e){
            System.out.println("Exception at moment to generate the Driver: " + e);
        }
        return webDriver;
    }


    public RemoteWebDriver startFirefox(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        try {
            FirefoxDriverManager.firefoxdriver().version("69.0").setup();
            webDriver = new FirefoxDriver(options);
            webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            //Initialize pages
            initPages(webDriver);
        }catch (Exception e){
            System.out.println("Exception at moment to generate the Driver: " + e);
        }
        return webDriver;
    }

    public void navigateTo (String url){
        webDriver.navigate().to(url);
    }

    @AfterClass
    public void closeDriver(){
        webDriver.quit();
    }

}

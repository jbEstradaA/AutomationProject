package com.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Method to do click on a WebElement
     * @param locator
     */
    public void clickOnElement(By locator){
        driver.findElement(locator).click();
    }

    /**
     * Method to fill a WebElement with a text value
     * @param locator
     * @param text
     */
    public void sendKeysToElement(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    /**
     * Method that return a value from WebElement
     * @param locator
     * @return
     */
    public String getTextFromElement(By locator){
        return driver.findElement(locator).getText();
    }

    /**
     * Method that return true if the WebElement is Enable.
     * @param locator
     * @return
     */
    public Boolean verifyIfElementIsEnabled(By locator){
        return driver.findElement(locator).isEnabled();
    }

    /**
     * Method that return true if the WebElement is displayed.
     * @param locator
     * @return
     */
    public Boolean verifyIfElementIsDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}

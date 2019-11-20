package com.framework;

import com.sun.prism.shader.AlphaOne_Color_AlphaTest_Loader;
import cucumber.runtime.java.Function;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
     * Method to do click on a WebElement
     * @param element
     */
    public void clickOnElement(WebElement element){
        element.click();
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
     * Method to do TAB key over an Element
     * @param locator
     */
    public void sendTabKeyToElement(By locator){
        driver.findElement(locator).sendKeys(Keys.TAB);
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
    public Boolean verifyIfElementIsDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }

    /**
     * This method allow select a item of a DropDownWebElement
     * @param locator
     * @param text
     */
    public void selectItemOfDrpElement(By locator, String text) {
        Select drpElement = new Select(driver.findElement(locator));
        drpElement.selectByVisibleText(text);
    }

    /**
     * This method return the class property name value from element
     * @param locator
     * @return
     */
    public String getClassNameFromElement(By locator){
        return driver.findElement(locator).getAttribute("class");
    }

    /**
     * This method returns a list of web elements that share a same feature
     * @param locator
     * @return
     */
    public List<WebElement> createAListOfWebElements(By locator) {
        return driver.findElements(locator);
    }

    /**
     * This method returns the size of a web element list
     * @param elements
     * @return
     */
    public int getSizeOfAWebElementList(List<WebElement> elements) {
        return elements.size();
    }

    /**
     * this method do click on a element inside of another web element of a WebElementList
     * @param elements
     * @param index
     * @param elementLocator
     */
    public void clickOnElementOfAListOfWebElements(List<WebElement> elements, int index, By elementLocator) {
        elements.get(index).findElement(elementLocator).click();
    }

    /**
     * this method get a text value of an element from a WebElementList
     * @param elements
     * @param index
     * @param elementLocator
     */
    public String getTextOfElementFromAListOfWebElements(List<WebElement> elements, int index, By elementLocator) {
        return  elements.get(index).findElement(elementLocator).getText();
    }

    /** -------FAIL 01
     * This method stops the script for "N" seconds or until a visibility web element appears
     * @param locator
     * @param seconds
     */
    public void waitNSecondsToAVisibilityElementAppears(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /** -------FAIL 02
     * This method stops the script for "N" seconds or until an invisibility web element appears
     * @param locator
     * @param seconds
     */
    public void waitNSecondsToAnInvisibilityElementAppears(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /** -------FAIL 03
     * This method stops the script for "N" seconds or until a web element to be clickable
     * @param locator
     * @param seconds
     */
    public void waitNSecondsToAnElementToBeClickable(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /** -------FAIL 04
     * This method is a fail T_T
     * @param locator
     */
    public void experimento(By locator){
        WebDriverWait wait = new WebDriverWait(driver,4);
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", el);
    }

    /** -------FAIL 05
     * This method is a fail too T_T
     * @param seconds
     */
    public void waitPageLoad(long seconds)  {
        driver.manage().timeouts().pageLoadTimeout(seconds,TimeUnit.SECONDS);
    }

    /* -------FAIL 06
    public void waitNSecondsToAnElementToBeClickable(By locator, int secsTimeout, int secsFrequency) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(secsTimeout))
                .pollingEvery(Duration.ofSeconds(secsFrequency)).ignoring(NoSuchElementException.class);


        WebElement foo = wait.until(new Function() {

    public WebElement apply(WebDriver driver) {

    return driver.findElement(locator);

           }
        });
    }
*/
    /* -------FAIL 07
    public void exp2(){
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>()
        {
            public WebElement apply(WebDriver arg0) {
                System.out.println("Checking for the element!!");
                WebElement element = arg0.findElement(By.id("target"));
                if(element != null)
                {
                    System.out.println("Target element found");
                }
                return element;
            }
        };

        wait.until(function);
    }
*/

    /**
     *This method simulate the action of move the cursor mouse over a web element
     * @param locator
     */
    public void simulateMouseOverAnElement(By locator){
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(locator);
        builder.moveToElement(element).build().perform();
    }

    public void fillArrayListWithADataTableColumn(DataTable dt, int dataTableHeader, List<String> arrayList) {
        List<List<String>> list = dt.asLists(String.class);
        for (int i = 1; i < list.size(); i++) {
            arrayList.add(list.get(i).get(dataTableHeader).toLowerCase());
            System.out.println(arrayList.get(i-1));
        }

    }
}

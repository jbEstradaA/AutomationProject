package com.automationPractice.pages;

import com.framework.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends ParentPage {

    public MainPage(WebDriver driver){
        super(driver);
    }

    By Module_Editorial = By.id("editorial_block_center");
    By Tittle_MainPage = By.xpath("//div[@id='editorial_block_center']//h1");
    By BTN_ContactUs = By.id("contact-link");

    /**
     * This Method return the principal tittle of the Main Page
     * @return String
     */
    public String getTittleOfMainPage(){
        return getTextFromElement(Tittle_MainPage);
    }

    /**
     * This Method do click into the ContactUs button in the Main Page
     * this button is located into the right top corner
     */
    public void clickOnContactButton(){
        clickOnElement(BTN_ContactUs);
    }

}

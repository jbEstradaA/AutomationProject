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
    By txt_search = By.id("search_query_top");
    By btn_search=By.name("submit_search");
    By Form_principal = By.id("center_column");
    By txt_result= By.className("lighter");

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

    /**
     * This Method send a word to the box search
     */
    public void sendSearch(String message){
        sendKeysToElement(txt_search,message);
    }

    /**
     * This Method do click into the search button in the Main Page
     */
    public void clickOnSearch(){
        clickOnElement(btn_search);
    }

    /**
     * This Method verify if the principal form is displayed
     */
    public Boolean verifyThatPrincipalFormIsDisplayed(){
        return verifyIfElementIsDisplayed(Form_principal);
    }

    /**
     * This Method get the search text
     */
    public String getSearch(){
        return getTextFromElement(txt_result);
    }
}


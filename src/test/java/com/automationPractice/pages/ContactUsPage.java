package com.automationPractice.pages;

import com.framework.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends ParentPage {
    public ContactUsPage (WebDriver webDriver){
        super(webDriver);
    }

    By Form_principal = By.id("center_column");
    By Tittle_ContactUsForm = By.xpath("//div[@id='center_column']//h1");

    /**
     * This Method is to verify if the principal form is Displayed
     */
    public Boolean verifyThatPrincipalFormIsDisplayed(){
        return verifyIfElementIsDisplayed(Form_principal);
    }


}

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
    By Select_subject = By.name("id_contact");
    By Span_subject = By.xpath("//div[@id='uniform-id_contact']/span");
    By Desc_subject2 = By.id("desc_contact2");
    By Desc_subject1 = By.id("desc_contact1");

    /**
     * This method is to verify if the principal form is Displayed
     */
    public Boolean verifyThatPrincipalFormIsDisplayed(){
        return verifyIfElementIsDisplayed(Form_principal);
    }

    /**
     * This method is to do click on the SelectControl of subject heading
     */
    public void doClickOnSubjectSelectControl(){
        clickOnElement(Select_subject);
    }

    /**
     * This method is used to select a determined subject of the SelectControl
     * @param Subject is the Subject type, can be "Customer service" or "Webmaster"
     */
    public void selectSubjectType(String Subject) {
        selectItemOfDrpElement(Select_subject, Subject);
    }

    /**
     * This method is used to get the text value of the Web element that contains the description of the selected subject
     * @return a description text value
     */
    public String getSubjectDescription() {
        String TextValue = getTextFromElement(Span_subject);
        switch (TextValue){
            case "Customer service":
                TextValue = getTextFromElement(Desc_subject2);
                break;
            case "Webmaster":
                TextValue = getTextFromElement(Desc_subject1);
                break;
        }
        return TextValue;
    }
}

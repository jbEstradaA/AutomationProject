package com.automationPractice.steps;

import com.automationPractice.AppTestRun;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CustomerServiceSteps extends AppTestRun {

    @Given("the user be in the automation practice principal web page")
    public void theUserBeInTheAutomationPracticePrincipalWebPage() {
        navigateTo("http://automationpractice.com/index.php");
    }

    @When("do click in the contact us button")
    public void doClickInTheContactUsButton() {
        mainPage.clickOnContactButton();
    }

    @Then("the CUSTOMER SERVICE from must be displayed")
    public void theCUSTOMERSERVICEFromMustBeDisplayed() {
        Assert.assertTrue(contactUsPage.verifyThatPrincipalFormIsDisplayed(),"The principal form has not been displayed correctly");
    }

    @Given("The user is in the CONTACT US section")
    public void theUserIsInTheCONTACTUSSection() {
        theUserBeInTheAutomationPracticePrincipalWebPage();
        doClickInTheContactUsButton();
    }

    @When("The user click on subject heading control")
    public void theUserClickOnSubjectHeadingControl() {
        contactUsPage.doClickOnSubjectSelectControl();
    }

    @And("The user select the subject type {string}")
    public void theUserSelectTheSubjectType(String Subject) {
        contactUsPage.selectSubjectType(Subject);
    }

    @Then("Verify that description message {string} must be displayed")
    public void verifyThatDescriptionMessageMustBeDisplayed(String textToBeShowed) {
        Assert.assertEquals(contactUsPage.getSubjectDescription(), textToBeShowed, "The description message of Subject "+ textToBeShowed + " has not been displayed correctly");
    }

    @When("enter the text {string} in the search text box")
    public void enterTheTextInTheSearchTextBox(String searchText) {
        mainPage.sendSearch(searchText);
    }

    @And("click in the search button")
    public void clickInTheSearchButton() {
        mainPage.clickOnSearch();
    }

    @Then("verify that the search word {string} is displayed in the results")
    public void verifyThatTheSearchWordIsDisplayedInTheResults(String searchText) {
        Assert.assertTrue(mainPage.getSearch().contains(searchText.toUpperCase()),"The search was "+searchText);
    }
}

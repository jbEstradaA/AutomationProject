package com.automationPractice.steps;

import com.automationPractice.AppTestRun;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CustomerServiceSteps extends AppTestRun {
    @Given("the user be in the automation practice principal web page")
    public void theUserBeInTheAutomationPracticePrincipalWebPage() {
        //startChrome();
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

    @Given("the user is in the CONTACT US section")
    public void theUserIsInTheCONTACTUSSection() {
        theUserBeInTheAutomationPracticePrincipalWebPage();
        doClickInTheContactUsButton();
    }

    @When("the user click on subject heading control")
    public void theUserClickOnSubjectHeadingControl() {
        contactUsPage.doClickOnSubjectSelectControl();
    }

    @And("the user select the subject type {string}")
    public void theUserSelectTheSubjectType(String Subject) {
        contactUsPage.selectSubjectType(Subject);
    }

    @Then("verify that description message {string} must be displayed")
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

    @And("the user enter an {string} in the Email address field")
    public void theUserEnterAnInTheEmailAddressField(String invalidEmail) {
        contactUsPage.enterEmail(invalidEmail);
    }

    @And("the left the Email address field")
    public void theLeftTheEmailAddressField() {
        contactUsPage.leftFieldEmailAddress();
    }

    @Then("verify that the field Email address should show a validation")
    public void verifyThatTheFieldEmailAddressShouldShowAValidation() {
        Assert.assertTrue(contactUsPage.verifyThatIsValidEmail(), "This is a valid Email");
    }

    @When("do click on women menu")
    public void doClickOnWomenMenu() {
        mainPage.clickOnWomenMenu();
    }

    @And("do click on dresses sub category button")
    public void doClickOnDressesSubCategoryButton() {
        mainPage.clickOnDressesSubCategory();
    }

    @And("choose the view to list mode")
    public void chooseTheViewToListMode() {
        catalogPage.changeViewToListMode();
    }

    @And("add the products with \"Reduced price!\" offer to the buy cart")
    public void addTheProductsWithOfferToTheBuyCart() {
        catalogPage.addProductsWithReducedPriceToTheShoppingCart();
    }

    @And("the user check out the buy cart summary")
    public void theUserCheckOutTheBuyCartSummary() {
        mainPage.showListOfShopCartMenu();
        mainPage.clickOnCheckOutButtonOfShopCartMenu();
    }

    @Then("verify that the following products should be displayed into Shopping cart")
    public void verifyThatTheFollowingProductsShouldBeDisplayedIntoShoppingCart(DataTable listOfProducts) {
        Assert.assertTrue(shoppingCartPage.verifyThatMyProductsMatchWithShoppingCartSummary(listOfProducts));
        System.out.println("\nThe wished products List match with the products in the shopping cart");
    }
}

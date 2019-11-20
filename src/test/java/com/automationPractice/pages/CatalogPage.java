package com.automationPractice.pages;

import com.framework.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogPage extends ParentPage {
    public CatalogPage(WebDriver webDriver){
        super(webDriver);
    }

    By productsInOffer = By.xpath("//span[@class='discount']/ancestor::div[@class='product-container']");
    By BTN_listView = By.id("list");
    By BTN_gridView = By.id("grid");
    By BTN_addToCart = By.cssSelector("[title='Add to cart']");
    By BTN_continueShopping = By.xpath("//span[@title='Continue shopping']");
    By MODAL_ShoppingCartDisplayed = By.xpath("//div[@id='layer_cart'][contains(@style,'block')]");
    By MODAL_ShoppingCartNoneDisplayed = By.xpath("//div[@id='layer_cart'][contains(@style,'none')]");

    public void changeViewToListMode() {
        handlingWaitForElementContainsSelectedAttribute(BTN_gridView);
        clickOnElement(BTN_listView);
    }

    public void addProductsWithReducedPriceToTheShoppingCart() {
        List<WebElement> elementList = createAListOfWebElements(productsInOffer);
        for (int i = 0; i < getSizeOfAWebElementList(elementList); i++){
            clickOnElementOfAListOfWebElements(elementList, i, BTN_addToCart);
            handlingWaitForElementToBeVisible(MODAL_ShoppingCartDisplayed);
            clickOnElement(BTN_continueShopping);
            handlingWaitForElementToNotBeInvisible(MODAL_ShoppingCartNoneDisplayed);
        }
    }

}

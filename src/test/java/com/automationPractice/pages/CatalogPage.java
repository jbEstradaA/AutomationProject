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
    By BTN_listView = By.xpath("//a[@title='List']");
    By BTN_addToCart = By.cssSelector("[title='Add to cart']");
    By LAYERED_loader = By.id("layered_ajax_loader");
    By BTN_continueShopping = By.xpath("//div[@class='button-container']/span");

    public void changeViewToListMode() throws Throwable {
        Thread.sleep(1000);
        clickOnElement(BTN_listView);
    }

    public void addProductsWithReducedPriceToTheShoppingCart() throws Throwable{
        List<WebElement> elementList = createAListOfWebElements(productsInOffer);
        for (int i = 0; i < getSizeOfAWebElementList(elementList); i++){
            clickOnElementOfAListOfWebElements(elementList, i, BTN_addToCart);
            //waitNSecondsToAnInvisibilityElementAppears(LAYERED_loader,2);
            //waitNSecondsToAnElementToBeClickable(BTN_continueShopping,2);
            //experimento(BTN_continueShopping);
            //waitPageLoad(4);
            Thread.sleep(2000); //ya ni idea de que más probar ¬¬
            clickOnElement(BTN_continueShopping);
        }
    }

}

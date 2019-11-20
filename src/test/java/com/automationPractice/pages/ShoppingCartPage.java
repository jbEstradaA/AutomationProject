package com.automationPractice.pages;

import com.framework.ParentPage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCartPage extends ParentPage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    By productsInShopCart = By.xpath("//p[@class='product-name']/ancestor::tr");
    By TEXT_link  = By.className("product-name");

    public void verifyThatMyProductsMatchWithShoppingCartSummary(DataTable dt, int dtHeader) {
        List<WebElement> shopCartElementList = createAListOfWebElements(productsInShopCart);
        List<String> wantedProductsList = new ArrayList<String>();
        List<String> AddedProductsList = new ArrayList<String>();

        System.out.println("\nList of products wished by the user:");
        fillArrayListWithADataTableColumn(dt, dtHeader, wantedProductsList);

        System.out.println("\nProducts added to Shopping Cart:");
        for (int i = 0; i < getSizeOfAWebElementList(shopCartElementList); i++){
            AddedProductsList.add(getTextOfElementFromAListOfWebElements(shopCartElementList,i,TEXT_link).toLowerCase());
            System.out.println(AddedProductsList.get(i));
        }
        Collections.sort(wantedProductsList);
        Collections.sort(AddedProductsList);

        Assert.assertEquals(AddedProductsList, wantedProductsList);
    }
}

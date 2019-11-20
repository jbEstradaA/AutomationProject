package com.automationPractice.pages;

import com.framework.ParentPage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShoppingCartPage extends ParentPage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    By productsInShopCart = By.xpath("//p[@class='product-name']/ancestor::tr");
    By TEXT_link  = By.className("product-name");

    public boolean verifyThatMyProductsMatchWithShoppingCartSummary(DataTable listOfProducts) {
        List<String> productList = createListWithElementsTextValue(productsInShopCart);
        AtomicBoolean productsMatches = new AtomicBoolean(false);
        for (int i = 1; i < listOfProducts.asList().size(); i++ ){
            for (int f = 0; f < productList.size(); f++ ) {
                if (productList.get(f).contains(listOfProducts.asList().get(i))) {
                    productsMatches.set(true);
                    break;
                } else
                    productsMatches.set(false);
            }
            if (!productsMatches.get())
                break;
        }
        return productsMatches.get();
    }

}

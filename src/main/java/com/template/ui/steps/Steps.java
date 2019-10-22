package com.template.ui.steps;

import com.template.ui.pages.onninen.*;
import io.qameta.allure.Step;

public class Steps {
    private static BasePage basePage = new BasePage();
    private static CartPage cartPage = new CartPage();
    private static ClientPage clientPage = new ClientPage();
    private static ProductPage productPage = new ProductPage();
    private static SearchPage searchPage = new SearchPage();


    @Step("Choose and add product to cart go to the client page")
    public static void addProductToCartAndGoToClientPage() {
        basePage.productSearch("Oswietlenie");
        searchPage.clickOnSearchItem(3);
        searchPage.chooseProduct();
        productPage.addProductToTheCart();
        String quantity = "2";
        cartPage.verifyCartContent(quantity);
    }
}

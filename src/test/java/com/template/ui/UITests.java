package com.template.ui;

import com.codeborne.selenide.Condition;
import com.template.ui.pages.onninen.*;
import com.template.ui.steps.Steps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class UITests extends BaseTest {

    private BasePage basePage = new BasePage();
    private CartPage cartPage = new CartPage();
    private ClientPage clientPage = new ClientPage();
    private ProductPage productPage = new ProductPage();
    private SearchPage searchPage = new SearchPage();
    private Steps steps = new Steps();

    @BeforeMethod
    public void openMainPage() {
        open(baseUrl);
        clearBrowserCookies();
    }

    @Test(description = "Positive test select and choose product, enter client data")
    public void testAddProductGoToClientPage() {
        basePage.productSearch("filter");

        //choose product from list
        searchPage.clickOnSearchItem(2);
        searchPage.chooseProduct();

        //IncreaseProductNumberAndGotoTheCart
        productPage.addProductToTheCart();

        //verify cart content
        String quantity = "2";
        cartPage.verifyCartContent(quantity);

        //verify client data
        clientPage.enterCorrectClientData();
        basePage.companyLogo().click();
    }

    @Test(description = "Negative test select and choose product, enter fill in not all required fields in ClientPage")
    public void testAddProductLeaveEmptyClientDataRequiredFields() {
        steps.addProductToCartAndGoToClientPage();
        clientPage.enterNonCorrectClientData();
        sleep(1000);
        clientPage.nonCorrectUserDataMessage.shouldBe(Condition.visible);
        clientPage.emptyPhoneNumberError.shouldBe(Condition.visible);
        clientPage.emptyEmailError.shouldBe(Condition.visible);
        clientPage.uncheckedPersonalDataCheckboxError.shouldBe(Condition.visible);
        basePage.companyLogo().click();
    }

    @Test(description = "Positive test choose some category validate category name")
    public void testValidateCategoryName() {
        basePage.openCategoryMenuChooseCategory();
        searchPage.categoryNameHeader.shouldHave(Condition.text(String.format("Energetyka")));
    }
}

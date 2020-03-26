package com.template.ui.pages.onninen;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
@Accessors(fluent = true)
public class BasePage {

    private SelenideElement companyLogo = $x("//a[@class=\"HeaderLogo__link\"]");
    private SelenideElement searchField = $("input[id=\"instant-search-input\"]");
    private SelenideElement searchButton = $("button[type=\"submit\"]");
    private SelenideElement categoryDropdownMenu = $("select[id=\"instant-search-category-input\"]");
    private SelenideElement productyLabel = $("div.Menu__item-inner a[title=\"Produkty\"]");
    private SelenideElement energetykaLabel = $("a.kat-glowna[title=\"Energetyka\"]");
    private SelenideElement weciejKontaktowLink = $("a.wiecej-kontakt");


    @Step
    public void productSearch(String productName) {
        searchField.setValue(productName);
    }

    @Step
    public void openCategoryMenuChooseCategory() {
        productyLabel.hover();
        energetykaLabel.click();
    }

    @Step
    public void clickWeciejKontaktowLink(){
        weciejKontaktowLink.scrollTo().click();
    }
}

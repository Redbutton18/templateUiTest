package com.template.ui.pages.onninen;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
@Accessors(fluent = true)
public class SearchPage extends BasePage{

    public ElementsCollection searchItem = $$("ul.InstantSearch__list li a span");
    public SelenideElement itemHeader = $("a.Product__header-title");
    public SelenideElement categoryNameHeader = $("h1[class=\"Title__title ProductListContent__list-header Title__align-left\"]");

    @Step
    public void clickOnSearchItem(int index){
        searchItem.get(index).click();
    }

    @Step
    public void chooseProduct() {
        itemHeader.click();
    }

}

package com.template.ui.pages.onninen;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Getter
@Accessors(fluent = true)

public class ProductPage extends BasePage {

    public SelenideElement plusItemNumberButton = $("button[class=\"Button__btn ProductBasket__increment Button__style-icon\"]");
    public SelenideElement goToCartButton = $("button[class=\"Button__btn ProductBasket__submit-button Button__breakable Button__style-danger\"]");
    public SelenideElement approveGoToCartButton = $("a[class=\"Button__btn Button__style-danger Button__size-small\"]");

    @Step
    public void addProductToTheCart() {

        plusItemNumberButton.shouldBe(visible).click();
        goToCartButton.click();
        approveGoToCartButton.shouldBe(visible).click();
    }

}

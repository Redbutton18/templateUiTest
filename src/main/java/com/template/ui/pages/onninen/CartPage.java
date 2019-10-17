package com.template.ui.pages.onninen;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

@Getter
@Accessors(fluent = true)

public class CartPage extends BasePage{

    public SelenideElement productQuantityField = $("input[class=\"Input__input BasketProductList__quantity-input\"]");
    public SelenideElement cartTitle = $("li[class=\"BasketSteps__item BasketSteps__active\"]");
    public SelenideElement daneClientaButton = $("button[form=\"basket-list-step-form\"]");
    public SelenideElement zakupyBezRejestracjiButton = $("button[class=\"Button__btn Button__full-width Button__breakable\"]   ");



    @Step
    public void verifyCartContent(String quantity) {
        sleep(2000);
        String itemQuantity = productQuantityField.getValue();
        cartTitle.shouldHave(Condition.text(String.format("Koszyk")));
        assertThat(itemQuantity).isEqualTo(quantity);
        daneClientaButton.click();
        zakupyBezRejestracjiButton.shouldBe(Condition.visible).click();
    }
}

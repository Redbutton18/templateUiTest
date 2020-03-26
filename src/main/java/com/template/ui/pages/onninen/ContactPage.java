package com.template.ui.pages.onninen;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

@Getter
@Accessors(fluent = true)

public class ContactPage {

    public SelenideElement contactHeader = $("div.str-kontakt h1");
    public SelenideElement mainCompanyAddress = $("div.blok:nth-child(4) p");
    public SelenideElement telephonSekretariat = $("a[href=\"tel:22 567 90 00\"]");
    public SelenideElement faxSekretariat = $("a[href=\"tel:22 567 90 09\"]");
    public SelenideElement openHoursSekretariat = $("div:nth-child(5) > p > span.godz > span");
    public SelenideElement emailSekretariat = $("a[data-contact-modal-to=\"info\"]");


}

package com.template.ui.pages.onninen;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.*;

@Getter
@Accessors(fluent = true)

public class ClientPage extends BasePage{

    public SelenideElement clientPageHeader = $("li[class=\"BasketSteps__item BasketSteps__active\"]   ");
    public SelenideElement nameField = $("input[id=\"prs_fname\"]");
    public SelenideElement surnameField = $("input[id=\"prs_lname\"]");
    public SelenideElement addressField = $("input[id=\"prs_street\"]");
    public SelenideElement postCodeField = $("input[id=\"prs_zip\"]");
    public SelenideElement cityField = $("input[id=\"prs_city\"]");
    public SelenideElement phoneNumberField = $("input[id=\"prs_phone\"]");
    public SelenideElement emailField = $("input[id=\"prs_email\"]");
    public SelenideElement acceptPersonalDataCheckbox = $("input#accept_proc_person_data.Checkbox__input");
    public SelenideElement nextButton = $("button[class=\"Button__btn Button__breakable Button__style-danger\"]");

    public SelenideElement nonCorrectUserDataMessage = $x("//div[@id='messenger']/ul[2]/li");
    public SelenideElement emptyPhoneNumberError = $x("//div[input[@id='prs_phone']]/../div[contains(@class, 'FormElement__error')]");
    public SelenideElement emptyEmailError = $x("//div[input[@id='prs_email']]/../div[contains(@class, 'FormElement__error')]");
    public SelenideElement uncheckedPersonalDataCheckboxError = $x("//div[input[@name=\"accept_proc_person_data\"]]/../div[contains(@class, 'FormElement__error')]");

    @Step
    public void enterCorrectClientData() {
        clientPageHeader.shouldHave(Condition.text(String.format("Dane klienta")));
        nameField.setValue("Asdsf");
        surnameField.setValue("Ssfgdffg");
        addressField.setValue("Dolna 22");
        postCodeField.setValue("50-001");
        cityField.setValue("Wroclaw");
        phoneNumberField.setValue("1234567890");
        emailField.setValue("asd@yahoo.com");
        acceptPersonalDataCheckbox.scrollTo().click();
        nextButton.click();
    }

    @Step
    public void enterNonCorrectClientData() {
        clientPageHeader.shouldHave(Condition.text(String.format("Dane klienta")));
        nameField.setValue("Asdsf");
        surnameField.setValue("Ssfgdffg");
        addressField.setValue("Dolna 22");
        postCodeField.setValue("50-001");
        cityField.setValue("Wroclaw");
        nextButton.scrollTo().click();

    }
}

package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class WebFormPage {

    private final SelenideElement countrySelect =
            $("[data-testid='forms-country']");

    private final SelenideElement titleSelect =
            $("[data-testid='forms-title']");

    private final SelenideElement firstNameInput =
            $("[data-testid='forms-first-name']");

    private final SelenideElement lastNameInput =
            $("[data-testid='forms-last-name']");

    private final SelenideElement dateOfBirthInput =
            $("[data-testid='forms-dob']");

    private final SelenideElement dateOfJoiningInput =
            $("[data-testid='forms-doj']");

    private final SelenideElement emailInput =
            $("[data-testid='forms-email']");

    private final SelenideElement phoneCodeSelect =
            $("[data-testid='forms-phone-code']");

    private final SelenideElement phoneNumberInput =
            $("[data-testid='forms-phone-number']");

    private final SelenideElement emailRadio =
            $("[data-testid='forms-comm-email']");

    private final SelenideElement phoneRadio =
            $("[data-testid='forms-comm-phone']");

    private final SelenideElement clearButton =
            $("[data-testid='forms-clear']");

    private final SelenideElement submitButton =
            $("[data-testid='forms-submit']");

    private final SelenideElement successMessage =
            $("[data-testid='forms-success']");

//    @Step("Open Web Form page")
//    public WebFormPage openPage() {
//        open("/practice-forms");
//
//        countrySelect.shouldBe(visible);
//
//        return this;
//    }

    @Step("Open Web Form page")
    public WebFormPage openPage() {
        open("/practice-forms");

        System.out.println("CURRENT URL: " + url());

        countrySelect.shouldBe(visible);

        return this;
    }

    @Step("Select country: {country}")
    public WebFormPage selectCountry(String country) {
        countrySelect
                .shouldBe(visible)
                .selectOption(country);

        return this;
    }

    @Step("Select title: {title}")
    public WebFormPage selectTitle(String title) {
        titleSelect
                .shouldBe(visible)
                .selectOption(title);

        return this;
    }

    @Step("Enter first name: {firstName}")
    public WebFormPage enterFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    @Step("Enter last name: {lastName}")
    public WebFormPage enterLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    @Step("Enter date of birth: {dateOfBirth}")
    public WebFormPage enterDateOfBirth(String dateOfBirth) {
        dateOfBirthInput.setValue(dateOfBirth);

        return this;
    }

    @Step("Enter date of joining: {dateOfJoining}")
    public WebFormPage enterDateOfJoining(String dateOfJoining) {
        dateOfJoiningInput.setValue(dateOfJoining);

        return this;
    }

    @Step("Enter email: {email}")
    public WebFormPage enterEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    @Step("Submit form")
    public WebFormPage submit() {
        submitButton
                .shouldBe(visible)
                .click();

        return this;
    }

    @Step("Clear form")
    public WebFormPage clear() {
        clearButton
                .shouldBe(visible)
                .click();

        return this;
    }
    @Step("Select phone code: {phoneCode}")
    public WebFormPage selectPhoneCode(String phoneCode) {
        phoneCodeSelect
                .shouldBe(visible)
                .selectOption(phoneCode);

        return this;
    }

    @Step("Enter phone number: {phoneNumber}")
    public WebFormPage enterPhoneNumber(String phoneNumber) {
        phoneNumberInput
                .shouldBe(visible)
                .setValue(phoneNumber);

        return this;
    }

    @Step("Select Email as preferred communication method")
    public WebFormPage selectEmailCommunication() {
        emailRadio
                .shouldBe(visible)
                .click();

        return this;
    }

    @Step("Select Phone as preferred communication method")
    public WebFormPage selectPhoneCommunication() {
        phoneRadio
                .shouldBe(visible)
                .click();

        return this;
    }
    @Step("Verify successful form submission")
    public WebFormPage verifySuccessfulSubmission() {
        successMessage
                .shouldBe(visible)
                .shouldHave(text("Details Successfully Added!"));

        return this;
    }
    @Step("Verify validation error: {expectedText}")
    public WebFormPage verifyValidationError(String expectedText) {
        $$("small.text-danger")
                .findBy(text(expectedText))
                .shouldBe(visible);

        return this;
    }
}
package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WebFormPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Epic("QA Practice")
@Feature("Web Form")
public class WebFormTests extends BaseTest {

    private final WebFormPage webFormPage = new WebFormPage();

    @Test
    @Story("Form submission")
    @Owner("Aikerim")
    @Severity(CRITICAL)
    @DisplayName("Submit web form with valid data")
    void submitWebFormWithValidDataTest() {
        webFormPage
                .openPage()
                .selectCountry("India")
                .selectTitle("Dr.")
                .enterFirstName("John")
                .enterLastName("Smith")
                .enterDateOfBirth("1995-05-20")
                .enterDateOfJoining("20/05/2025")
                .enterEmail("john.smith@test.com")
                .selectPhoneCode("+91")
                .enterPhoneNumber("9876543210")
                .selectEmailCommunication()
                .submit()
                .verifySuccessfulSubmission();
    }

    @Test
    @Story("Form validation")
    @Owner("Aikerim")
    @Severity(NORMAL)
    @DisplayName("Validation errors are displayed for empty required fields")
    void submitEmptyWebFormTest() {
        webFormPage
                .openPage()
                .submit()
                .verifyValidationError("Date of Birth is required")
                .verifyValidationError("Email Address is required")
                .verifyValidationError("Phone Number is required")
                .verifyValidationError("Please select a Communication Preference");
    }
}
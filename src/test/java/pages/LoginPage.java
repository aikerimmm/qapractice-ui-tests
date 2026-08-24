package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private final SelenideElement emailInput = $("[data-testid='login-email']");
    private final SelenideElement passwordInput = $("[data-testid='login-password']");
    private final SelenideElement signInButton = $("[data-testid='login-submit']");
    private final SelenideElement successMessage = $("[data-testid='login-success']");
    private final SelenideElement errorMessage = $("[data-testid='login-error']");

    @Step("Open login page")
    public LoginPage openPage() {
        open("/practice-login-form");

        emailInput.shouldBe(visible);

        return this;
    }

    @Step("Login with email: {email}")
    public LoginPage login(String email, String password) {
        emailInput
                .shouldBe(visible)
                .setValue(email);

        passwordInput
                .shouldBe(visible)
                .setValue(password);

        signInButton
                .shouldBe(enabled)
                .click();

        return this;
    }

    @Step("Verify successful login")
    public LoginPage verifySuccessfulLogin() {
        successMessage
                .shouldBe(visible)
                .shouldHave(text("Login Successful!"));

        return this;
    }
    @Step("Verify login error message: {expectedMessage}")
    public LoginPage verifyErrorMessage(String expectedMessage) {
        errorMessage
                .shouldBe(visible)
                .shouldHave(text(expectedMessage));

        return this;
    }
}
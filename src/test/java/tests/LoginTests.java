package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Epic("QA Practice")
@Feature("Authentication")
public class LoginTests extends BaseTest {

    private final LoginPage loginPage = new LoginPage();

    @Test
    @Story("Login")
    @Owner("Aikerim")
    @Severity(CRITICAL)
    @DisplayName("Successful login with valid credentials")
    void successfulLoginTest() {
        loginPage
                .openPage()
                .login("user@premiumbank.com", "Bank@123")
                .verifySuccessfulLogin();
    }

    @ParameterizedTest(name = "Login with email={0} and password={1}")
    @CsvSource({
            "wrong@premiumbank.com, Bank@123",
            "user@premiumbank.com, wrongPassword"
    })
    @Story("Login validation")
    @Owner("Aikerim")
    @Severity(NORMAL)
    @DisplayName("Login with invalid credentials")
    void loginWithInvalidCredentialsTest(String email, String password) {
        loginPage
                .openPage()
                .login(email, password)
                .verifyErrorMessage("Invalid email id and password");
    }

    @ParameterizedTest(name = "Email: {0}, Password: {1} -> {2}")
    @CsvSource({
            "'', Bank@123, Email is required",
            "user@premiumbank.com, '', Password is required"
    })
    @Story("Login validation")
    @Owner("Aikerim")
    @Severity(NORMAL)
    @DisplayName("Login with empty required fields")
    void loginWithEmptyRequiredFieldsTest(String email, String password, String expectedError) {
        loginPage
                .openPage()
                .login(email, password)
                .verifyErrorMessage(expectedError);
    }
}
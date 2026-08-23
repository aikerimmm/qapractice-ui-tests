package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl =
                System.getProperty("baseUrl", "https://www.qapractice.com");

        Configuration.browser =
                System.getProperty("browser", "chrome");

        Configuration.browserSize =
                System.getProperty("browserSize", "1920x1080");

        String browserVersion = System.getProperty("browserVersion");
        if (browserVersion != null && !browserVersion.isBlank()) {
            Configuration.browserVersion = browserVersion;
        }

        String remote = System.getProperty("remote");
        if (remote != null && !remote.isBlank()) {
            Configuration.remote = remote;
        }
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener(
                "AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(false)
        );
    }

    @AfterEach
    void tearDown() {
        Attachments.addScreenshot();
        Attachments.addPageSource();
        Attachments.addBrowserConsoleLogs();

        closeWebDriver();
    }
}
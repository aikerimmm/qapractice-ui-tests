package helpers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogType;

import java.io.ByteArrayInputStream;

public class Attachments {

    public static void addScreenshot() {
        if (!WebDriverRunner.hasWebDriverStarted()) {
            return;
        }

        byte[] screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver())
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment(
                "Screenshot",
                new ByteArrayInputStream(screenshot)
        );
    }

    public static void addPageSource() {
        if (!WebDriverRunner.hasWebDriverStarted()) {
            return;
        }

        String pageSource = WebDriverRunner.getWebDriver().getPageSource();

        Allure.addAttachment(
                "Page source",
                "text/html",
                pageSource,
                ".html"
        );
    }

    public static void addBrowserConsoleLogs() {
        if (!WebDriverRunner.hasWebDriverStarted()) {
            return;
        }

        String logs = WebDriverRunner.getWebDriver()
                .manage()
                .logs()
                .get(LogType.BROWSER)
                .getAll()
                .toString();

        Allure.addAttachment(
                "Browser console logs",
                "text/plain",
                logs,
                ".log"
        );
    }
}
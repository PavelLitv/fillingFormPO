package guru.qa.pageobject.tests;

import guru.qa.pageobject.helpers.Attach;
import guru.qa.pageobject.pages.RegistrationPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static guru.qa.pageobject.helpers.DriverHelper.JENKINS;
import static guru.qa.pageobject.helpers.DriverHelper.configDriver;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Step("Конфигурирование драйвера")
    @BeforeAll
    static void beforeAll() {
        configDriver();
    }

    @AfterEach
    void addAttachments() {
        if (JENKINS) {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        }
    }
}

package guru.qa.pageobject.tests;

import guru.qa.pageobject.config.WebDriverConfig;
import guru.qa.pageobject.helpers.Attach;
import guru.qa.pageobject.pages.RegistrationPage;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static guru.qa.pageobject.helpers.DriverHelper.configDriver;

public class TestBase {

    protected RegistrationPage registrationPage = new RegistrationPage();

    private static final WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class);

    @Step("Конфигурирование драйвера")
    @BeforeAll
    static void beforeAll() {
        configDriver(config);
    }

    @AfterEach
    void tearDown() {
        if (config.isRemote()) {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo(config.getSelenoidUrl());
        }
    }
}

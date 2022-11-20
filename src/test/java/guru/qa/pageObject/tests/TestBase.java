package guru.qa.pageObject.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pageObject.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }
}
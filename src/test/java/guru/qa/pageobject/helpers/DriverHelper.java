package guru.qa.pageobject.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverHelper {

    public static final boolean JENKINS = true;

    public static void configDriver(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//        Configuration.holdBrowserOpen = true;

        if(JENKINS) {
            Configuration.timeout = 10000;
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}
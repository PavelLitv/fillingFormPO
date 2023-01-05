package guru.qa.pageobject.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:./properties/${envBrowser}-browser.properties"
})

public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("firefox")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("108.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1024x768")
    String getBrowserSize();

    @Key("holdBrowserOpen")
    @DefaultValue("true")
    Boolean getHoldBrowserOpen();

    @Key("timeout")
    @DefaultValue("4000")
    Long getTimeout();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();

    @Key("selenoidUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud")
    String getSelenoidUrl();
}

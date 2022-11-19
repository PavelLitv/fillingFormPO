package guru.qa.PO.pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationResultsModal {
    public void registrationModalAppears() {
        $(".modal-content").should(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResult(String verifyField, String value) {
        $x("//td[text()='" + verifyField + "']/following::td").shouldHave(text(value));
    }
}

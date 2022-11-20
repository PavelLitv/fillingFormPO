package guru.qa.pageObject.pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
    public void registrationModalAppears() {
        $(".modal-content").should(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResult(String verifyField, String value) {
        $(".table-responsive").$(byText(verifyField)).parent().shouldHave(text(value));
    }
}

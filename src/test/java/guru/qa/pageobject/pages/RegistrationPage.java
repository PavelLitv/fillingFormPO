package guru.qa.pageobject.pages;

import guru.qa.pageobject.pages.components.ICalendar;
import guru.qa.pageobject.pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage implements ICalendar {

    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        $("#firstName").sendKeys(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        $("#lastName").sendKeys(lastName);

        return this;
    }

    public RegistrationPage setUserEmail(String email) {
        $("#userEmail").sendKeys(email);

        return this;
    }

    public RegistrationPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();

        return this;
    }

    public RegistrationPage setPhone(String phone) {
        $("#userNumber").sendKeys(phone);

        return this;
    }

    public RegistrationPage setBirthDayDate(String birthDay, String birthMonth, String birthYear) {
        $("#dateOfBirthInput").click();
        setDate(birthDay, birthMonth, birthYear);
        return this;
    }

    public RegistrationPage setSubject(String subjects) {
        $("#subjectsInput").setValue(subjects).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        $("#hobbiesWrapper").$(byText(hobbies)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String picture) {
        $("#uploadPicture").uploadFromClasspath(picture);

        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        $("#currentAddress").sendKeys(currentAddress);

        return this;
    }

    public RegistrationPage setState(String state) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();

        return this;
    }

    public RegistrationPage setCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        return this;
    }

    public RegistrationPage submit() {
        $("#submit").click();

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.registrationModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String verifyField, String value) {
        registrationResultsModal.verifyResult(verifyField, value);

        return this;
    }
}

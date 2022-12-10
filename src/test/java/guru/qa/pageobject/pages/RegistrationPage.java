package guru.qa.pageobject.pages;

import guru.qa.pageobject.pages.components.Calendar;
import guru.qa.pageobject.pages.components.RegistrationResultsModal;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    Calendar calendar = new Calendar();

    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    @Step("открыть страницу регистрационной формы")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    @Step("заполнить поле First Name - {firstName}")
    public RegistrationPage setFirstName(String firstName) {
        $("#firstName").sendKeys(firstName);

        return this;
    }

    @Step("заполнить поле Last Name - {lastName}")
    public RegistrationPage setLastName(String lastName) {
        $("#lastName").sendKeys(lastName);

        return this;
    }

    @Step("заполнить поле email - {email}")
    public RegistrationPage setUserEmail(String email) {
        $("#userEmail").sendKeys(email);

        return this;
    }

    @Step("выбрать чекбокс Gender - {gender}")
    public RegistrationPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();

        return this;
    }

    @Step("заполнить Mobile - {phone}")
    public RegistrationPage setPhone(String phone) {
        $("#userNumber").sendKeys(phone);

        return this;
    }

    @Step("установить Date of Birth - {birthday}")
    public RegistrationPage setBirthDayDate(String birthday) {
        $("#dateOfBirthInput").click();
        calendar.setDate(birthday);
        return this;
    }

    @Step("выбрать Subject - {subjects}")
    public RegistrationPage setSubject(String subjects) {
        $("#subjectsInput").setValue(subjects).pressEnter();

        return this;
    }

    @Step("выбрать чекбокс Hobbies - {hobbies}")
    public RegistrationPage setHobbies(String hobbies) {
        $("#hobbiesWrapper").$(byText(hobbies)).click();

        return this;
    }

    @Step("загрузить файл - {picture}")
    public RegistrationPage uploadPicture(String picture) {
        $("#uploadPicture").uploadFromClasspath(picture);

        return this;
    }

    @Step("заполнить поле Current Address - {currentAddress}")
    public RegistrationPage setCurrentAddress(String currentAddress) {
        $("#currentAddress").sendKeys(currentAddress);

        return this;
    }

    @Step("выбрать State - {state}")
    public RegistrationPage setState(String state) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();

        return this;
    }

    @Step("выбрать City - {city}")
    public RegistrationPage setCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        return this;
    }

    @Step("отправить форму")
    public RegistrationPage submit() {
        $("#submit").click();

        return this;
    }

    @Step("модальное окно результаты появилось")
    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.registrationModalAppears();

        return this;
    }

    @Step("проверяем, что поле {verifyField} содержит {value}")
    public RegistrationPage verifyResult(String verifyField, String value) {
        registrationResultsModal.verifyResult(verifyField, value);

        return this;
    }
}

package guru.qa.pageobject.tests;

import guru.qa.pageobject.testdata.StudentRegistrationFormData;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FillFormTest extends TestBase {

    @Test
    @Owner("Pavel Li")
    @DisplayName("check student form")
    void fillingFormTest() {
        StudentRegistrationFormData regFormData = new StudentRegistrationFormData();

        registrationPage.openPage()
                .setFirstName(regFormData.firstName)
                .setLastName(regFormData.lastName)
                .setUserEmail(regFormData.email)
                .setGender(regFormData.gender)
                .setPhone(regFormData.phone)
                .setBirthDayDate(regFormData.getBirthday())
                .setSubject(regFormData.subjects)
                .setHobbies(regFormData.hobbies)
                .uploadPicture(regFormData.picture)
                .setCurrentAddress(regFormData.currentAddress)
                .setState(regFormData.state)
                .setCity(regFormData.city)
                .submit()
                .verifyResultsModalAppears()
                .verifyResult("Student Name", regFormData.firstName + " " + regFormData.lastName)
                .verifyResult("Student Email", regFormData.email)
                .verifyResult("Gender", regFormData.gender)
                .verifyResult("Mobile", regFormData.phone)
                .verifyResult("Date of Birth", regFormData.getBirthday())
                .verifyResult("Subjects", regFormData.subjects)
                .verifyResult("Hobbies", regFormData.hobbies)
                .verifyResult("Picture", regFormData.picture.substring(4))
                .verifyResult("Address", regFormData.currentAddress)
                .verifyResult("State and City", regFormData.state + " " + regFormData.city);
    }
}

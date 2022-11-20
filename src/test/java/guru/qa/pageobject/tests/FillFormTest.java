package guru.qa.pageobject.tests;

import org.junit.jupiter.api.Test;

import static guru.qa.pageobject.testdata.StudentRegistrationFormData.*;

public class FillFormTest extends TestBase {
    @Test
    void fillingFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDayDate(birthDay, birthMonth, birthYear)
                .setSubject(subjects)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit()
                .verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth",
                        birthDay + " " + birthMonth + "," + birthYear)
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", picture.substring(4))
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);
    }
}

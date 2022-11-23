package guru.qa.pageobject.tests;

import guru.qa.pageobject.testdata.StudentRegistrationFormData;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class FillFormTest extends TestBase {
    @Test
    void fillingFormTest() {
        StudentRegistrationFormData regFormData = new StudentRegistrationFormData();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMM,yyyy", Locale.ENGLISH);

        registrationPage.openPage()
                .setFirstName(regFormData.firstName)
                .setLastName(regFormData.lastName)
                .setUserEmail(regFormData.email)
                .setGender(regFormData.gender)
                .setPhone(regFormData.phone)
                .setBirthDayDate(regFormData.birthday)
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
                .verifyResult("Date of Birth",formatter.format(regFormData.birthday))
                .verifyResult("Subjects", regFormData.subjects)
                .verifyResult("Hobbies", regFormData.hobbies)
                .verifyResult("Picture", regFormData.picture.substring(4))
                .verifyResult("Address", regFormData.currentAddress)
                .verifyResult("State and City", regFormData.state + " " + regFormData.city);
    }
}

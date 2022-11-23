package guru.qa.pageobject.tests;

import guru.qa.pageobject.testdata.StudentRegistrationFormData;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class FillFormTest extends TestBase {
    @Test
    void fillingFormTest() {
        StudentRegistrationFormData regForm = new StudentRegistrationFormData();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMM,yyyy", Locale.ENGLISH);

        registrationPage.openPage()
                .setFirstName(regForm.firstName)
                .setLastName(regForm.lastName)
                .setUserEmail(regForm.email)
                .setGender(regForm.gender)
                .setPhone(regForm.phone)
                .setBirthDayDate(regForm.birthday)
                .setSubject(regForm.subjects)
                .setHobbies(regForm.hobbies)
                .uploadPicture(regForm.picture)
                .setCurrentAddress(regForm.currentAddress)
                .setState(regForm.state)
                .setCity(regForm.city)
                .submit()
                .verifyResultsModalAppears()
                .verifyResult("Student Name", regForm.firstName + " " + regForm.lastName)
                .verifyResult("Student Email", regForm.email)
                .verifyResult("Gender", regForm.gender)
                .verifyResult("Mobile", regForm.phone)
                .verifyResult("Date of Birth",formatter.format(regForm.birthday))
                .verifyResult("Subjects", regForm.subjects)
                .verifyResult("Hobbies", regForm.hobbies)
                .verifyResult("Picture", regForm.picture.substring(4))
                .verifyResult("Address", regForm.currentAddress)
                .verifyResult("State and City", regForm.state + " " + regForm.city);
    }
}

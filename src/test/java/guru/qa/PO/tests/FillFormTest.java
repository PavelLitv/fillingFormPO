package guru.qa.PO.tests;

import org.junit.jupiter.api.Test;

public class FillFormTest extends TestBase {
    @Test
    void fillingFormTest() {
        String firstName = "Pavel",
                lastName = "Li",
                email = "pavel_li@gmail.com",
                gender = "Male",
                phone = "7909808707",
                birthDay = "06",
                birthMonth = "March",
                birthYear = "1980",
                subjects = "Arts",
                hobbies = "Sports",
                picture = "img/photo.jpg",
                currentAddress = "luxury village somewhere in Siberia",
                state = "Haryana",
                city = "Karnal";

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

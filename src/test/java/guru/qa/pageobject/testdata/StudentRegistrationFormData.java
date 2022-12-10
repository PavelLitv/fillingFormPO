package guru.qa.pageobject.testdata;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static guru.qa.pageobject.testdata.RandomData.*;

public class StudentRegistrationFormData {
    public String
            firstName,
            lastName,
            email,
            gender,
            phone,
            subjects,
            hobbies,
            picture,
            currentAddress,
            state,
            city;
    public Date birthday;

    public StudentRegistrationFormData(){
        this.firstName = getRandomFirstName();
        this.lastName = getRandomLastName();
        this.email = getRandomEmail();
        this.gender = getRandomGender();
        this.phone = getRandomNumber(10);
        this.birthday = getRandomBirthday();
        this.subjects = getRandomSubject();
        this.hobbies = getRandomHobbies();
        this.picture = "img/photo.jpg";
        this.currentAddress = getRandomAddress();
        this.state = getRandomState();
        this.city = getRandomCity(state);
    }

    public String getBirthday() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMM,yyyy", Locale.ENGLISH);
        return formatter.format(birthday);
    }
}

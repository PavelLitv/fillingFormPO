package guru.qa.pageobject.testdata;

import com.github.javafaker.Faker;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomData {

    static Random random = new Random();

    public static String getRandomFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String getRandomNumber(int length) {
        Faker faker = new Faker();
        return faker.number().digits(length);
    }

    public static Date getRandomBirthday() {
        Faker faker = new Faker();
        return faker.date().birthday();
    }

    public static String getRandomAddress() {
        Faker faker = new Faker();
        return faker.address().fullAddress();
    }

    public static String getRandomGender() {
        String[] arraySubject = {"Male", "Female", "Other"};
        return arraySubject[random.nextInt(arraySubject.length)];
    }

    public static String getRandomSubject() {
        String[] arraySubject = {"Maths", "Arts", "Commerce", "Civics", "Hindi"};
        return arraySubject[random.nextInt(arraySubject.length)];
    }

    public static String getRandomHobbies() {
        String[] arraySubject = {"Sports", "Reading", "Music"};
        return arraySubject[random.nextInt(arraySubject.length)];
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return states[random.nextInt(states.length)];
    }

    public static String getRandomCity(String key) {
        Map<String, String[]> mapStateAndCity = new HashMap<>();
        mapStateAndCity.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        mapStateAndCity.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        mapStateAndCity.put("Haryana", new String[]{"Karnal", "Panipat"});
        mapStateAndCity.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});

        String[] cities = mapStateAndCity.get(key);
        return cities[random.nextInt(cities.length)];
    }
}

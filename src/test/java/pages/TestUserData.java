package pages;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class TestUserData {

    private static final Faker faker = new Faker(new Locale("en-US"));
    static Random random = new Random();
    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            phone = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(10, 28)),
            month = getRandomMonth(),
            year = String.valueOf(faker.number().numberBetween(1980, 2006)),
            subject = getRandomSubject(),
            hobby = getRandomHobby(),
            currentAddress = faker.address().fullAddress();

    public static String getRandomMonth() {
        String[] month = {"January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"};
        int randomIndex = random.nextInt(month.length);
        return month[randomIndex];
    }

    public static String getRandomSubject() {
        String[] subject = {"Maths", "Chemistry", "Computer Science",
                "Commerce", "Economics"};
        int randomIndex = random.nextInt(subject.length);
        return subject[randomIndex];
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        int randomIndex = random.nextInt(hobbies.length);
        return hobbies[randomIndex];
    }

    public static String getRandomLocation() {
        List<String> state = Arrays.asList(
                "NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        location = state.get(new Random().nextInt(state.size()));
        return location;
    }

    public static String
            location = getRandomLocation(),
            town = getRandomTown();

    public static String getRandomTown() {
        List<String> town;
        switch (location) {
            case ("NCR"):
                town = Arrays.asList(
                        "Delhi", "Gurgaon", "Noida");
                return town.get(new Random().nextInt(town.size()));
            case ("Uttar Pradesh"):
                town = Arrays.asList(
                        "Agra", "Lucknow", "Merrut");
                return town.get(new Random().nextInt(town.size()));
            case ("Haryana"):
                town = Arrays.asList(
                        "Karnal", "Panipat");
                return town.get(new Random().nextInt(town.size()));
            case ("Rajasthan"):
                town = Arrays.asList(
                        "Jaipur", "Jaiselmer");
                return town.get(new Random().nextInt(town.size()));
        }
        return null;
    }
}




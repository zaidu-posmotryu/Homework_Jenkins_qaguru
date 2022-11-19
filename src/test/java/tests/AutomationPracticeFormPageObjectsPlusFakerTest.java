package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;
import pages.TestUserData;

import static io.qameta.allure.Allure.step;

public class AutomationPracticeFormPageObjectsPlusFakerTest extends TestUserData {
    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1600x1200";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @Test
    void checkFormTest() {
        step("Заполняю регистрационную форму", () -> {
            automationPracticeFormPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setUserNumber(phone)
                    .setBirthDate(day, month, year)
                    .setSubjects(subject)
                    .setHobby(hobby)
                    .uploadPicture()
                    .setAddress(currentAddress)
                    .setLocation(location, town)
                    .submitTheForm();
        });

        step("Проверяю правильность заполнения данными", () -> {
            automationPracticeFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", phone)
                    .checkResult("Date of Birth", day + " " + month + "," + year)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobby)
                    .checkResult("Picture", "this_is_my_life.jpg")
                    .checkResult("Address", currentAddress)
                    .checkResult("State and City", location + " " + town);
        });
    }
}

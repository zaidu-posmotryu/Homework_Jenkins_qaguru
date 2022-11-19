package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;
import pages.components.StateAndCityComponent;
import pages.components.SubjectsComponent;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    private SubjectsComponent subjectsComponent = new SubjectsComponent();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            addressInput = $("#currentAddress");

    private final static String TITLE_TEXT = "Student Registration Form";

    private static final Faker faker = new Faker(new Locale("en-US"));

    public AutomationPracticeFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public AutomationPracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage setUserNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public AutomationPracticeFormPage setSubjects(String subj) {
        subjectsComponent.setSubject(subj);
        return this;
    }

    public AutomationPracticeFormPage setHobby(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage uploadPicture() {
        $("input#uploadPicture").uploadFile(new File("src/test/resources/this_is_my_life.jpg"));
        ;
        return this;
    }

    public AutomationPracticeFormPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setLocation(String state, String city) {
        stateAndCityComponent.setStateAndCity(state, city);
        return this;
    }

    public AutomationPracticeFormPage submitTheForm() {
        $("[id=submit]").click();
        return this;
    }

    public AutomationPracticeFormPage checkResultsTableVisible() {
        resultsTableComponent.checkVisible();
        return this;
    }

    public AutomationPracticeFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);
        return this;
    }
}

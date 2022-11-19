package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubjectsComponent {

    public SubjectsComponent setSubject(String value) {
        $ ("#subjectsInput").setValue(value).pressEnter();
        return this;
    }
}

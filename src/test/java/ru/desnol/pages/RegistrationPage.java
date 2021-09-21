package ru.desnol.pages;


import ru.desnol.pages.components.CalendarComponent;
import ru.desnol.pages.components.StateCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class RegistrationPage {
    private final String FORM_TITLE = "Student Registration Form";

    public CalendarComponent calendar = new CalendarComponent();

    public StateCityComponent state = new StateCityComponent();

    public void openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public void typeLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }

    public void typeUserEmail(String userEmail) {
        $("#userEmail").setValue(userEmail);
    }

    public void typeCurrentAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
    }

    public void typeUserNumber(String userNumber) {
        $("#userNumber").setValue(userNumber);
    }

    public void clickGender(String gender){
        $("#genterWrapper").$(byText(gender)).click();
    }

    public void typeSubject(String subject){
        $("#subjectsInput").setValue(subject).pressEnter();
    }

    public void clickHobbies(String hobbies){
        $("#hobbiesWrapper").$(byText(hobbies)).click();
    }

    public void loadFile (String file){
        $("#uploadPicture").scrollTo();
        $("#uploadPicture").uploadFromClasspath(file);
}

    public void getTitle(String title){
        $(".modal-title").shouldHave(text(title));
    }

    public void checkResultsValue(String key, String value) {
        $x("//td[text()='" + key + "']").parent().shouldHave(text(value));
    }


}





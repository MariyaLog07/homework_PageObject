package ru.desnol.pages;

import com.codeborne.selenide.SelenideElement;
import ru.desnol.pages.components.CalendarComponent;
import ru.desnol.pages.components.StateCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput=$("#currentAddress"),
            userNumberInput=$("#userNumber");

    public CalendarComponent calendar = new CalendarComponent();

    public StateCityComponent state = new StateCityComponent();

    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public void typeLastName(String value) {

        lastNameInput.setValue(value);
    }

    public void typeUserEmail(String value) {
        userEmailInput.setValue(value);
    }
    public void typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
    }
    public void typeUserNumber(String value) {
        userNumberInput.setValue(value);
    }
}





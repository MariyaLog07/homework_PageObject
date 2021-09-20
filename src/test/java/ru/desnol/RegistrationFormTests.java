package ru.desnol;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static ru.desnol.TestData.*;

public class RegistrationFormTests extends TestBase  {

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8900369852");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("2020");
        $(".react-datepicker__day--025:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").scrollTo();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Lermontova street,1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName), text("Test@gmail.com"), text("Female"),
                text("8900369852"), text("25 August,2020"), text("Maths"),
                text("Sports"), text("1.png"), text("Lermontova street,1"), text("NCR Delhi"));
    }

}

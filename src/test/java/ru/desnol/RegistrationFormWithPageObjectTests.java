package ru.desnol;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import ru.desnol.pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static ru.desnol.TestData.userNumber;


public class RegistrationFormWithPageObjectTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            currentAddress= faker.yoda().quote();
    @Test
    void fillFormTest() {
        registrationPage.openPage();

        registrationPage.typeFirstName(firstName)
                        .typeLastName(lastName);
        registrationPage.typeUserEmail(userEmail);
        $("#genterWrapper").$(byText("Female")).click();
       registrationPage.typeUserNumber(userNumber);
        registrationPage.calendar.setDate("25","August","2020");
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").scrollTo();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        registrationPage.typeCurrentAddress(currentAddress);
        registrationPage.state.SetCity("NCR","Delhi");
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName), text(userEmail),
                        text("Female"), text(userNumber), text("25 August,2020"), text("Maths"),
           text("Sports"), text("1.png"), text(currentAddress), text("NCR Delhi"));
    }

}

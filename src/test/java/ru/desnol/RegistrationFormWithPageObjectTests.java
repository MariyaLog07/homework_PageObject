package ru.desnol;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import ru.desnol.pages.RegistrationPage;



public class RegistrationFormWithPageObjectTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            currentAddress = faker.yoda().quote(),
            userNumber = "8900369852",
            gender = "Female",
            subject = "Math",
            hobbies = "Sports",
            file = "img/1.png",
            title = "Thanks for submitting the form",
            picture = "1.png";

    @Test
    void fillFormTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName)
                .typeLastName(lastName);
        registrationPage.typeUserEmail(userEmail);
        registrationPage.clickGender(gender);
        registrationPage.typeUserNumber(userNumber);
        registrationPage.calendar.setDate("25", "August", "2020");
        registrationPage.typeSubject(subject);
        registrationPage.clickHobbies(hobbies);
        registrationPage.loadFile(file);
        registrationPage.typeCurrentAddress(currentAddress);
        registrationPage.state.setCity("NCR", "Delhi");
        registrationPage.getTitle(title);
        registrationPage.checkResultsValue("Student Name",firstName+" "+ lastName);
        registrationPage.checkResultsValue("Student Email",userEmail);
        registrationPage.checkResultsValue("Gender",gender);
        registrationPage.checkResultsValue("Mobile",userNumber);
        registrationPage.checkResultsValue("Date of Birth","25 August,2020");
        registrationPage.checkResultsValue("Subjects",subject);
        registrationPage.checkResultsValue("Hobbies",hobbies);
        registrationPage.checkResultsValue("Picture",picture);
        registrationPage.checkResultsValue("Address",currentAddress);
        registrationPage.checkResultsValue("State and City", "NCR Delhi");
    }

}

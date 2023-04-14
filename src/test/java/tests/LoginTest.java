package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        loginPage.attemptValidLoginData();
        loginPage.checkSuccessMessage();
        $(loginPage.successMessage).should(Condition.exist);
        $(loginPage.successMessage).shouldHave(Condition.exactText(loginPage.expectedSuccessMessage));
    }

    @Test
    public void invalidLoginTest() {
        loginPage.attemptInvalidLoginData();
        loginPage.checkErrorMessage();
        $(loginPage.errorMessage).should(Condition.exist);
        $(loginPage.errorMessage).shouldHave(Condition.exactText(loginPage.expectedErrorMessage));
    }
}

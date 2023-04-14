package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    static LoginPage loginPage = null;
    private final By EMAIL_FIELD = By.xpath("//input[@name='email']");
    private final By PASSWORD_FIELD = By.xpath("//input[@name='password']");
    private final By LOGIN_BUTTON = By.xpath("//button[@name='login']");
    private final String CORRECT_EMAIL = "michal.rzavucki@gmail.com";
    private final String CORRECT_PASSWORD = "30203050";
    private final String INCORRECT_EMAIL = "test@mail.com";
    private final String INCORRECT_PASSWORD = "sdf325fhg";
    public By successMessage = By.xpath("//div[@class='notice success']");
    public String expectedSuccessMessage = "You are now logged in as Michal Rzavucki.";
    public By errorMessage = By.xpath("//div[@class='notice errors']");
    public String expectedErrorMessage = "Wrong password or the account is disabled, or does not exist";

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public static LoginPage getInstance(WebDriver webDriver) {
        if (loginPage == null) {
            loginPage = new LoginPage(webDriver);
        }
        return loginPage;
    }

    public void attemptValidLoginData() {
        $(EMAIL_FIELD).shouldBe(Condition.exist).sendKeys(CORRECT_EMAIL);
        $(PASSWORD_FIELD).shouldBe(Condition.exist).sendKeys(CORRECT_PASSWORD);
        $(LOGIN_BUTTON).shouldBe(Condition.exist).click();
    }

    public void attemptInvalidLoginData() {
        $(EMAIL_FIELD).shouldBe(Condition.exist).sendKeys(INCORRECT_EMAIL);
        $(PASSWORD_FIELD).shouldBe(Condition.exist).sendKeys(INCORRECT_PASSWORD);
        $(LOGIN_BUTTON).shouldBe(Condition.exist).click();
    }

    public void checkErrorMessage() {
        System.out.println($(errorMessage).shouldBe(Condition.exist).getText());
    }

    public void checkSuccessMessage() {
        System.out.println($(successMessage).shouldBe(Condition.exist).getText());
    }

}

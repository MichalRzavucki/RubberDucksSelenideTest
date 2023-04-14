package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;
import pages.RubberDucksPage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    private final String HOME_PAGE = "https://litecart.stqa.ru/en/";
    WebDriver webDriver;
    LoginPage loginPage;
    RubberDucksPage rubberDucksPage;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        loginPage = LoginPage.getInstance(webDriver);
        rubberDucksPage = RubberDucksPage.getInstance(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
    }

    @BeforeMethod
    public void beforeMethod() {
        webDriver.manage().deleteAllCookies();
        open(HOME_PAGE);
    }

    @AfterTest
    public void teardown() {
        webDriver.quit();
    }
}

package tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    private WebDriver driver;
    LoginPage loginPage;
    FeedPage feedPage;
    MoodUpdatedModal moodUpdatedModal;
    RateYourHappinessModal rateYourHappinessModal;
    MyDiaryPage myDiaryPage;
    public static final String USERNAME = System.getProperty("username");
    public static final String PASSWORD = System.getProperty("password");
    public static final String URL = "https://moodpanda.com";

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.browserVersion = "86.0.4240.111";
        loginPage = new LoginPage(driver);
        feedPage = new FeedPage(driver);
        rateYourHappinessModal = new RateYourHappinessModal(driver);
        moodUpdatedModal = new MoodUpdatedModal(driver);
        myDiaryPage = new MyDiaryPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        WebDriverRunner.getWebDriver().quit();
    }
}

package tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.Configuration;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.PropertyReader;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    LoginPage loginPage;
    FeedPage feedPage;
    MoodUpdatedModal moodUpdatedModal;
    RateYourHappinessModal rateYourHappinessModal;
    MyDiaryPage myDiaryPage;
    public static final String USERNAME = System.getProperty("username");
    //System.getenv().getOrDefault("username",PropertyReader.getProperty("username"));
    public static final String PASSWORD = System.getProperty("password");
    //System.getenv().getOrDefault("password", PropertyReader.getProperty("password"));
    public static final String URL = "https://moodpanda.com";

    @BeforeMethod
    public void setup(ITestContext context) {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.browserVersion = "86.0.4240.111";
        loginPage = new LoginPage();
        feedPage = new FeedPage();
        rateYourHappinessModal = new RateYourHappinessModal();
        moodUpdatedModal = new MoodUpdatedModal();
        myDiaryPage = new MyDiaryPage();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        WebDriverRunner.getWebDriver().quit();
    }
}

package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;
import static tests.BaseTest.URL;
import utils.AllureUtils;

public class LoginPage extends BasePage {

    public static String EMAIL_CSS = "#ContentPlaceHolderContent_TextBoxEmail";
    public static String PASS_CSS = "#ContentPlaceHolderContent_TextBoxPassword";
    public static String LOGIN_BTN_CSS = "#ContentPlaceHolderContent_ButtonLogin";
    public static String GP_ICON_CSS = "[alt='MoodPanda Android App on Google Play']";
    public static String endpoint = "/login";

    public LoginPage login(String username, String password) {
        $(EMAIL_CSS).setValue(username);
        $(PASS_CSS).setValue(password);
        $(LOGIN_BTN_CSS).click();
        return this;
    }

    public LoginPage isPageOpened() {
        $(GP_ICON_CSS).waitUntil(Condition.visible, 10000);
        return this;
    }

    @Step("Login page was opened")
    public LoginPage openPage() {
        open(URL + endpoint);
        isPageOpened();
        AllureUtils.takeScreenshot();
        return this;
    }

}

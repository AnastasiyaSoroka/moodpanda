package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BasePage {

    public static final String UPDATE_MOOD_CSS = "#LinkUpdate";

    public FeedPage updateMood() {
        return this;
    }

    @Step("Feed page was opened")
    public FeedPage isPageOpened() {
        $(UPDATE_MOOD_CSS).waitUntil(Condition.visible, 10000);
        return this;
    }

    @Step("Update button was clicked")
    public FeedPage clickUpdate() {
        $(UPDATE_MOOD_CSS).click();
        return this;
    }

}

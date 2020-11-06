package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import utils.AllureUtils;

import static com.codeborne.selenide.Selenide.$;

public class MoodUpdatedModal extends BasePage {

    public static final String GOTODIARY_BTN_CSS = ".ButtonMyDiary";

    @Step("Mood Update popup was opened")
    public MoodUpdatedModal isPageOpened() {
        $(GOTODIARY_BTN_CSS).waitUntil(Condition.visible, 10000);
        AllureUtils.takeScreenshot();
        return this;
    }

    @Step("Click Go To My Diary button")
    public MoodUpdatedModal goToMyDiaryBtn() {
        $(GOTODIARY_BTN_CSS).click();
        return this;
    }

}

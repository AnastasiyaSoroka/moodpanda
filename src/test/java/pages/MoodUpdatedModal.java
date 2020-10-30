package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MoodUpdatedModal extends BasePage {

    public static final String LABEL_CSS = ".modal-title";
    public static final String GOTODIARY_BTN_CSS = ".ButtonMyDiary";

    public MoodUpdatedModal isPageOpened() {
        $(LABEL_CSS).waitUntil(Condition.visible, 10000);
        return this;
    }

    public MoodUpdatedModal updateMood() {
        return this;
    }

    @Step("Click Go To My Diary button")
    public MoodUpdatedModal goToMyDiaryBtn() {
        $(GOTODIARY_BTN_CSS).click();
        return this;
    }

}

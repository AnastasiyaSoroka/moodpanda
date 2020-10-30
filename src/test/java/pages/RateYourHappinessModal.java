package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utils.MyCalendar;
import utils.MyClock;

import static com.codeborne.selenide.Selenide.$;

public class RateYourHappinessModal extends BasePage {

    public static final String SLIDER_CSS = ".ui-slider-handle";
    public static final String DESCRIPTION_CSS = ".UpdateMoodText";
    public static final String UPDATE_BTN_CSS = ".ButtonUpdate";
    public static final String RESET_BTN_CSS = ".Reset%s";

    MyCalendar myCalendar = new MyCalendar();
    MyClock myClock = new MyClock();
    String resetDays = "Now";

    public void resetDaySelection(int daysAgo) {
        switch (daysAgo) {
            case 0:
                resetDays = "Now";
                break;
            case 1:
                resetDays = "Yesterday";
                break;
            case 2:
                resetDays = "2day";
                break;
            case 3:
                resetDays = "3day";

                break;
            default:
                resetDays = "Older";
                break;
        }
    }

    public RateYourHappinessModal isPageOpened() {
        $(SLIDER_CSS).waitUntil(Condition.visible, 10000);
        return this;
    }

    public RateYourHappinessModal updateMood() {
        return this;
    }

    @Step("Click Update Mood button")
    public RateYourHappinessModal updateMoodBtn() {
        $(UPDATE_BTN_CSS).click();
        return this;
    }

    public void changeSlider(int moodRating) {
        int defaultMood = 5;
        $(SLIDER_CSS).click();
        Keys direction;
        if (moodRating > defaultMood) {
            direction = Keys.ARROW_RIGHT;
        } else {
            direction = Keys.ARROW_LEFT;
        }
        for (int i = 0; i < Math.abs(moodRating - defaultMood); i++) {
            $(SLIDER_CSS).sendKeys(direction);
        }
    }

    @Step("Update Mood form with rate and description")
    public RateYourHappinessModal updateMood(int moodRating, String description) {
        changeSlider(moodRating);
        $(DESCRIPTION_CSS).setValue(description);
        updateMoodBtn();
        return this;
    }

    @Step("Update Mood form with rate, description and several days ago")
    public RateYourHappinessModal updateMood(int moodRating, String description, int days) {
        changeSlider(moodRating);
        $(DESCRIPTION_CSS).setValue(description);
        resetDaySelection(days);
        $(String.format(RESET_BTN_CSS, resetDays)).click();
        if ((days >= 4) || (days < 1)) {
            myCalendar.calendarUpdate(days);
        }
        updateMoodBtn();
        return this;
    }

    @Step("Update Mood form with rate, description and selected date")
    public RateYourHappinessModal updateMood(int moodRating, String description, String date) {
        changeSlider(moodRating);
        $(DESCRIPTION_CSS).setValue(description);
        int days = (int) myCalendar.getNoOfDaysBtwnDates(date);
        resetDaySelection(days);
        $(String.format(RESET_BTN_CSS, resetDays)).click();
        if ((days >= 4) || (days < 1)) {
            myCalendar.calendarUpdate(days);
        }
        updateMoodBtn();
        return this;
    }

    @Step("Update Mood form with rate, description, selected date and hour")
    public RateYourHappinessModal updateMood(int moodRating, String description, String date, int hour) {
        changeSlider(moodRating);
        $(DESCRIPTION_CSS).setValue(description);
        int days = (int) myCalendar.getNoOfDaysBtwnDates(date);
        resetDaySelection(days);
        $(String.format(RESET_BTN_CSS, resetDays)).click();
        if ((days >= 4) || (days < 1)) {
            myCalendar.calendarUpdate(days);
        }
        if ((hour >= 1) && (days < 24)) {
            myClock.hourUpdate(hour);
        }
        updateMoodBtn();
        return this;
    }

}

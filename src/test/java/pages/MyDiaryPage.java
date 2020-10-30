package pages;

import com.codeborne.selenide.Condition;

import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class MyDiaryPage extends BasePage {

    public static final String RATE_CSS = ".badge-";
    public static final String DESCRIPTION_CSS = ".MoodPostItem";
    public static final String DATE_CSS = ".text-muteda";

    public MyDiaryPage(WebDriver driver) {
        super(driver);
    }

    public String getRate(int rateMood) {
        return $(RATE_CSS + Integer.toString(rateMood)).getText();
    }

    public String getDescription() {
        return $(DESCRIPTION_CSS).getText();
    }

    public String getDate() {
        return $(DATE_CSS).getText();
    }

    public MyDiaryPage isPageOpened() {
        $(DESCRIPTION_CSS).waitUntil(Condition.visible, 10000);
        return this;
    }

    public MyDiaryPage updateMood() {
        return this;
    }

}

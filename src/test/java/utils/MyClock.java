package utils;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyClock {

    public static final String HOUR_CSS = ".DateHour";
    public static final String HOUR_OPTION = "//select[contains(@class,'DateHour')]/option[%s]";

    public void hourUpdate(int hour) {
        $(HOUR_CSS).waitUntil(Condition.visible, 10000);
        $(HOUR_CSS).click();
        $(byXpath(String.format(HOUR_OPTION, hour + 1))).click();
    }
}

package utils;

import com.codeborne.selenide.Condition;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyCalendar {

    public static final String CALENDAR_CSS = ".ui-datepicker-calendar";
    public static final String MONTH_CSS = ".ui-datepicker-month";
    public static final String MONTH_OPTION = "//select[@class='ui-datepicker-month']/option[%s]";
    public static final String YEAR_CSS = ".ui-datepicker-year";
    public static final String YEAR_OPTION = "//select[@class='ui-datepicker-year']/option[@value='%s']";
    public static final String DATE_OPTION = "//*[@class='ui-datepicker-calendar']//*[text()='%s']";

    public void calendarUpdate(int days) {
        $(CALENDAR_CSS).waitUntil(Condition.visible, 10000);
        $(MONTH_CSS).click();
        $(byXpath(String.format(MONTH_OPTION, getSelectedMonth(days) + 1))).click();
        $(YEAR_CSS).click();
        $(byXpath(String.format(YEAR_OPTION, getSelectedYear(days)))).click();
        $(byXpath(String.format(DATE_OPTION, getSelectedDate(days)))).click();
    }

    public int getSelectedDate(int days) {
        Calendar calReturn = Calendar.getInstance();
        calReturn.add(Calendar.DATE, -days);
        return calReturn.get(Calendar.DATE);
    }

    public int getSelectedMonth(int days) {
        Calendar calReturn = Calendar.getInstance();
        calReturn.add(Calendar.DATE, -days);
        return calReturn.get(Calendar.MONTH);
    }

    public int getSelectedYear(int days) {
        Calendar calReturn = Calendar.getInstance();
        calReturn.add(Calendar.DATE, -days);
        return calReturn.get(Calendar.YEAR);
    }

    public long getNoOfDaysBtwnDates(String expiryDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        Date expDate = null;
        long diff = 0;
        long noOfDays = 0;
        try {
            expDate = formatter.parse(expiryDate);
            Date createdDate = new Date();
            diff = expDate.getTime() - createdDate.getTime();
            noOfDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -noOfDays;
    }

}

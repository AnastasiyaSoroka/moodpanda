package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest {

    public int moodRating;
    public String description;
    public int daysAgo;
    public int hour;
    public String date;

    @Test(description = "Check that User can update his mood with rate and description only")
    public void checkMoodUpdatedNowTest() {

        moodRating = 8;
        description = "description description";

        loginPage.openPage()
                .login(USERNAME, PASSWORD);
        feedPage.isPageOpened()
                .clickUpdate();
        rateYourHappinessModal
                .isPageOpened()
                .updateMood(moodRating, description);
        moodUpdatedModal
                .isPageOpened()
                .goToMyDiaryBtn();

        String actualRate = myDiaryPage
                .isPageOpened()
                .getRate(moodRating);

        Assert.assertEquals(actualRate, Integer.toString(moodRating), "Rate is not correct in the Dairy");

        String actualDescription = myDiaryPage
                .getDescription();

        Assert.assertEquals(actualDescription, description, "Description is not correct in the Dairy");

    }

    @Test(description = "Check that User can update his mood with rate, description and several days ago")
    public void checkMoodUpdatedDaysTest() {
        moodRating = 6;
        description = "description 1";
        daysAgo = 3;

        loginPage.openPage()
                .login(USERNAME, PASSWORD);
        feedPage.isPageOpened()
                .clickUpdate();

        rateYourHappinessModal
                .isPageOpened()
                .updateMood(moodRating, description, daysAgo);
        moodUpdatedModal
                .isPageOpened()
                .goToMyDiaryBtn();

        String actualRate = myDiaryPage
                .isPageOpened()
                .getRate(moodRating);

        Assert.assertEquals(actualRate, Integer.toString(moodRating), "Rate is not correct in the Dairy");

        String actualDescription = myDiaryPage
                .getDescription();

        Assert.assertEquals(actualDescription, description, "Description is not correct in the Dairy");
    }

    @Test(description = "Check that User can update his mood with rate, description and selected date")
    public void checkMoodUpdatedDateTest() {
        moodRating = 6;
        description = "description 1";
        date = "23 Oct 2020";

        loginPage.openPage()
                .login(USERNAME, PASSWORD);
        feedPage.isPageOpened()
                .clickUpdate();

        rateYourHappinessModal
                .isPageOpened()
                .updateMood(moodRating, description, date);
        moodUpdatedModal
                .isPageOpened()
                .goToMyDiaryBtn();

        String actualRate = myDiaryPage
                .isPageOpened()
                .getRate(moodRating);

        Assert.assertEquals(actualRate, Integer.toString(moodRating), "Rate is not correct in the Dairy");

        String actualDescription = myDiaryPage
                .getDescription();

        Assert.assertEquals(actualDescription, description, "Description is not correct in the Dairy");

    }

    @Test(description = "Check that User can update his mood with rate, description, selected date and hour")
    public void checkMoodUpdatedHourTest() {
        moodRating = 9;
        description = "description 333";
        date = "23 Oct 2020";
        hour = 4;

        loginPage.openPage()
                .login(USERNAME, PASSWORD);
        feedPage.isPageOpened()
                .clickUpdate();

        rateYourHappinessModal
                .isPageOpened()
                .updateMood(moodRating, description, date, hour);
        moodUpdatedModal
                .isPageOpened()
                .goToMyDiaryBtn();

        String actualRate = myDiaryPage
                .isPageOpened()
                .getRate(moodRating);

        Assert.assertEquals(actualRate, Integer.toString(moodRating), "Rate is not correct in the Dairy");

        String actualDescription = myDiaryPage
                .getDescription();

        Assert.assertEquals(actualDescription, description, "Description is not correct in the Dairy");
    }

}

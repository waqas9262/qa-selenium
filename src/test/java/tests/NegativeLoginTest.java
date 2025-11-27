package tests;

import core.ExtentTestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import pages.NegativeLoginPage;
import core.BaseTest;
import org.testng.annotations.Test;

// Validates negative login scenarios such as invalid and empty credentials.
@Listeners(ExtentTestListener.class)
public class NegativeLoginTest extends BaseTest {

    @Test
    public void negativeLoginTest() {

        NegativeLoginPage negative = new NegativeLoginPage(driver);
        negative.negative("batman", "secret_sauce");

        // Assert generic invalid login error appears
        Assert.assertTrue(driver.getPageSource().contains("Epic sadface"));
    }

    @Test
    public void emptyFieldsTest() {

        NegativeLoginPage negative = new NegativeLoginPage(driver);
        negative.negative("", "");

        // Assert specific empty-field error appears
        Assert.assertTrue(driver.getPageSource().contains("Username is required"));
    }
}
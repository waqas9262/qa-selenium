package tests;

import org.testng.Assert;
import pages.NegativeLoginPage;
import core.BaseTest;
import org.testng.annotations.Test;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void negativeLoginTest() {

        // Navigate to the login page
        driver.get("https://www.saucedemo.com/");

        // Perform login with invalid credentials using the Page Object
        NegativeLoginPage negative = new NegativeLoginPage(driver);
        negative.negative("batman", "secret_sauce");

        // Validate error message appears for invalid login attempt
        Assert.assertTrue(driver.getPageSource().contains("Epic sadface"));
    }

    @Test
    public void emptyFieldsTest() {

        // Navigate to the login page
        driver.get("https://www.saucedemo.com/");

        // Perform login with empty credentials using the Page Object
        NegativeLoginPage negative = new NegativeLoginPage(driver);
        negative.negative("", "");

        // Validate error message appears for invalid login attempt
        Assert.assertTrue(driver.getPageSource().contains("Username is required"));
    }
}
package tests;

import core.ExtentTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import pages.NegativeLoginPage;
import core.BaseTest;
import org.testng.annotations.Test;

import java.time.Duration;

// Validates negative login scenarios such as invalid and empty credentials.
@Listeners(ExtentTestListener.class)
public class NegativeLoginTest extends BaseTest {

    @Test
    public void negativeLoginTest() {

        NegativeLoginPage negative = new NegativeLoginPage(driver);
        negative.negative("batman", "secret_sauce");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='error']")
                ));

        // Assert generic invalid login error appears
        Assert.assertTrue(driver.getPageSource().contains("Epic sadface"));
    }

    @Test
    public void emptyFieldsTest() {

        NegativeLoginPage negative = new NegativeLoginPage(driver);
        negative.negative("", "");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='error']")
                ));

        // Assert specific empty-field error appears
        Assert.assertTrue(driver.getPageSource().contains("Username is required"));
    }
}
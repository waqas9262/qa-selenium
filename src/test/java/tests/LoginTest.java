package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.testng.annotations.Listeners;
import core.ExtentTestListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

// Verifies successful login with default credentials.
@Listeners(ExtentTestListener.class)
public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithDefaultUser();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("inventory.html"));
    }
}
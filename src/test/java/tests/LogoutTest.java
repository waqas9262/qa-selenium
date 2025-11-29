package tests;

import core.BaseTest;
import core.ExtentTestListener;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;

// Validates that a logged-in user can successfully log out.
@Listeners(ExtentTestListener.class)

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithDefaultUser();

        new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(5))
                .until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(
                        By.id("logout_sidebar_link")
                ));

        MenuPage menu = new MenuPage(driver);
        menu.clickMenu();
        menu.clickLogout();
    }
}
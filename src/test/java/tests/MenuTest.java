package tests;

import core.BaseTest;
import core.ExtentTestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;

// Validates that the menu opens and logout can be triggered.
@Listeners(ExtentTestListener.class)
public class MenuTest extends BaseTest {

    @Test
    public void menuTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithDefaultUser();

        MenuPage menu = new MenuPage(driver);
        menu.clickMenu();
        menu.clickLogout();
    }
}
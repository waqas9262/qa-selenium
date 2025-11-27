package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;

// Validates that the menu opens and logout can be triggered.
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
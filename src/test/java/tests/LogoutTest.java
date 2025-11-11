package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        // Step 1: Open website
        driver.get("https://www.saucedemo.com/");

        // Step 2: Login
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // Step 3: Open menu and log out
        MenuPage menu = new MenuPage(driver);
        menu.clickMenu();
        menu.clickLogout();
    }
}
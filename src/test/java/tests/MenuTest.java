package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;

public class MenuTest extends BaseTest {

    @Test
    public void menuTest() {

        // Step 1: Open the Sauce Demo website
        driver.get("https://www.saucedemo.com/");

        // Step 2: Log in using the login page
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // Step 3: Open menu and log out
        MenuPage menu = new MenuPage(driver);
        menu.clickMenu();
        menu.clickLogout();
    }
}
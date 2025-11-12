package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        // Step 1: Open website
        driver.get("https://www.saucedemo.com/");

        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

    }
}
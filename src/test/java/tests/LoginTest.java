package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

// Verifies successful login with default credentials.
public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithDefaultUser();
    }
}
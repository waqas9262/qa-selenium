package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.testng.annotations.Listeners;
import core.ExtentTestListener;

// Verifies successful login with default credentials.
@Listeners(ExtentTestListener.class)
public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithDefaultUser();
    }
}
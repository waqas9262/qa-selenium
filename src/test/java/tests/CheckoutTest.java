package tests;

import core.BaseTest;
import core.ExtentTestListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;

import java.time.Duration;

// End-to-end checkout test from login to order completion.
@Listeners(ExtentTestListener.class)
public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithDefaultUser();

        CartPage cart = new CartPage(driver);
        cart.addBackpackToCart();
        cart.addBikelightToCart();
        cart.openCart();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.checkout("John", "Snow", "TTT 333");

        wait.until(ExpectedConditions.urlContains("checkout-complete"));
    }
}
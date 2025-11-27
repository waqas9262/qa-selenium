package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;

// End-to-end checkout test from login to order completion.
public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithDefaultUser();

        CartPage cart = new CartPage(driver);
        cart.addBackpackToCart();
        cart.addBikelightToCart();
        cart.openCart();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.checkout("John", "Snow", "TTT 333");
    }
}
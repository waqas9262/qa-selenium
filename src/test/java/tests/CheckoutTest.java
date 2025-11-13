package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        // Load application
        driver.get("https://www.saucedemo.com/");

        // Login using POM
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // Add items and open cart
        CartPage cart = new CartPage(driver);
        cart.addBackpackToCart();
        cart.addBikelightToCart();
        cart.openCart();

        // Complete checkout flow
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.checkout("John", "Snow", "TTT 333");
    }
}
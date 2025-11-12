package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import pages.CartPage;
import pages.LoginPage;
import core.BaseTest;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void cartTest() {

        // Open the SauceDemo website
        driver.get("https://www.saucedemo.com/");

        // Log in using valid credentials
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // Create CartPage object to access cart actions
        CartPage cart = new CartPage(driver);

        // Add two items to the cart
        cart.addBackpackToCart();
        cart.addBikelightToCart();

        // Verify cart badge shows 2 items
        String badge = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(badge, "2");

        // Open the cart and remove one item
        cart.openCart();
        cart.setRemoveItem();

        // Verify cart badge updates to 1 item
        String badgeAfter = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(badgeAfter, "1");
    }
}
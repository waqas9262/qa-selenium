package tests;

import core.ExtentTestListener;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import pages.CartPage;
import pages.LoginPage;
import core.BaseTest;
import org.testng.annotations.Test;

// Validates cart interactions including adding and removing items.
@Listeners(ExtentTestListener.class)
public class CartTest extends BaseTest {

    @Test
    public void cartTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithDefaultUser();

        CartPage cart = new CartPage(driver);

        cart.addBackpackToCart();
        cart.addBikelightToCart();

        // Assert cart shows two added items
        String badge = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(badge, "2");

        cart.openCart();
        cart.setRemoveItem();

        // Assert cart updates to one item
        String badgeAfter = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(badgeAfter, "1");
    }
}
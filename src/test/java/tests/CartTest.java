package tests;

import core.ExtentTestListener;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import pages.CartPage;
import pages.LoginPage;
import core.BaseTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

// Validates cart interactions including adding and removing items.
@Listeners(ExtentTestListener.class)
public class CartTest extends BaseTest {

    @Test
    public void cartTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithDefaultUser();

        CartPage cart = new CartPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        cart.addBackpackToCart();
        cart.addBikelightToCart();

        // Wait until cart badge shows 2 items
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("shopping_cart_badge"), "2"));
        String badge = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(badge, "2");

        // Open the cart and remove one item
        cart.openCart();
        cart.setRemoveItem();

        // Wait until cart badge updates to 1 item
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("shopping_cart_badge"), "1"));
        String badgeAfter = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(badgeAfter, "1");
    }
}
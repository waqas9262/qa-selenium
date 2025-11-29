package tests;

import core.ExtentTestListener;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import pages.InventoryPage;
import core.BaseTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

// Validates basic interactions on the inventory page.
@Listeners(ExtentTestListener.class)
public class InventoryTest extends BaseTest {

    @Test
    public void inventoryTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithDefaultUser();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("inventory_list")
        ));
        
        InventoryPage inventory = new InventoryPage(driver);
        inventory.openMenu();
        inventory.addBackpackToCart();
        inventory.openCart();
    }
}
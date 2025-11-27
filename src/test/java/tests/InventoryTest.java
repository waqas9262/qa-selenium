package tests;

import core.ExtentTestListener;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import pages.InventoryPage;
import core.BaseTest;
import org.testng.annotations.Test;

// Validates basic interactions on the inventory page.
@Listeners(ExtentTestListener.class)
public class InventoryTest extends BaseTest {

    @Test
    public void inventoryTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithDefaultUser();

        InventoryPage inventory = new InventoryPage(driver);
        inventory.openMenu();
        inventory.addBackpackToCart();
        inventory.openCart();
    }
}
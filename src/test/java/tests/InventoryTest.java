package tests;

import pages.LoginPage;
import pages.InventoryPage;
import core.BaseTest;
import org.testng.annotations.Test;

// Validates basic interactions on the inventory page.
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
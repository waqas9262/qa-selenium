package tests;

import pages.LoginPage;
import pages.InventoryPage;
import core.BaseTest;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {

    @Test
    public void inventoryTest() {

        // Open website
        driver.get("https://www.saucedemo.com/");

        // Login using Page Object
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // Work with Inventory page
        InventoryPage inventory = new InventoryPage(driver);
        inventory.openMenu();
        inventory.addBackpackToCart();
        inventory.openCart();
    }
}
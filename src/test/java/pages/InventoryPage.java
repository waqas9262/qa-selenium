package pages;

import core.LoggerManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Page Object for inventory interactions.
public class InventoryPage {

    private final WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By menuButton = By.id("react-burger-menu-btn");
    private final By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartIcon = By.id("shopping_cart_container");

    public void openMenu() {
        LoggerManager.getLogger().info("Opening side menu");
        driver.findElement(menuButton).click();
    }

    public void addBackpackToCart() {
        LoggerManager.getLogger().info("Adding backpack from inventory");
        driver.findElement(addBackpack).click();
    }

    public void openCart() {
        LoggerManager.getLogger().info("Opening cart from inventory page");
        driver.findElement(cartIcon).click();
    }
}
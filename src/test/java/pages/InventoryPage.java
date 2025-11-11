package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private final WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for inventory page elements
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartIcon = By.id("shopping_cart_container");

    // Opens the side menu
    public void openMenu() {
        driver.findElement(menuButton).click();
    }

    // Adds the backpack item to the cart
    public void addBackpackToCart() {
        driver.findElement(addBackpack).click();
    }

    // Opens the shopping cart
    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}
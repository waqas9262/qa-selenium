package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for cart-related elements
    private final By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By addBikelight = By.id("add-to-cart-sauce-labs-bike-light");
    private final By cartIcon = By.id("shopping_cart_container");
    private final By removeItem = By.id("remove-sauce-labs-backpack");

    // Add backpack item to the cart
    public void addBackpackToCart() {
        driver.findElement(addBackpack).click();
    }

    // Add bike light item to the cart
    public void addBikelightToCart() {
        driver.findElement(addBikelight).click();
    }

    // Open the shopping cart page
    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    // Remove one item from the cart
    public void setRemoveItem() {
        driver.findElement(removeItem).click();
    }
}
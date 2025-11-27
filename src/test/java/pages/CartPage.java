package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Page Object for cart-related interactions.
public class CartPage {

    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By addBikelight = By.id("add-to-cart-sauce-labs-bike-light");
    private final By cartIcon = By.id("shopping_cart_container");
    private final By removeItem = By.id("remove-sauce-labs-backpack");

    public void addBackpackToCart() {
        driver.findElement(addBackpack).click();
    }

    public void addBikelightToCart() {
        driver.findElement(addBikelight).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public void setRemoveItem() {
        driver.findElement(removeItem).click();
    }
}
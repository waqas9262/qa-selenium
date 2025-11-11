package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuPage {

    private final WebDriver driver;

    // Constructor
    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By hamburgerMenu = By.id("react-burger-menu-btn");
    private final By logout_link = By.id("logout_sidebar_link");

    // Click the menu button to open sidebar
    public void clickMenu() {
        driver.findElement(hamburgerMenu).click();
    }

    // Wait for the logout button to be clickable and then click it
    public void clickLogout() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(logout_link))
                .click();
    }
}
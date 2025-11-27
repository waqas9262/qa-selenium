package pages;

import core.LoggerManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Page Object for sidebar menu interactions.
public class MenuPage {

    private final WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By hamburgerMenu = By.id("react-burger-menu-btn");
    private final By logout_link = By.id("logout_sidebar_link");

    public void clickMenu() {
        LoggerManager.getLogger().info("Opening hamburger menu");
        driver.findElement(hamburgerMenu).click();
    }

    public void clickLogout() {
        LoggerManager.getLogger().info("Clicking logout");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(logout_link))
                .click();
    }
}
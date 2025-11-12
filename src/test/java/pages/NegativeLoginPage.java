package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NegativeLoginPage {

    private final WebDriver driver;

    public NegativeLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for login page elements
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");

    // Enter username
    public void enterUsername(String username) {
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
    }

    // Enter password
    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    // Click login button
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // Execute invalid login attempt
    public void negative(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
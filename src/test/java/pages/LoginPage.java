package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import core.ConfigManager;

// Page Object for login-related interactions.
public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // Login using default credentials from config.
    public void loginWithDefaultUser() {
        String username = ConfigManager.getUsername();
        String password = ConfigManager.getPassword();
        login(username, password);
    }
}
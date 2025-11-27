package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Page Object for negative login scenarios.
public class NegativeLoginPage {

    private final WebDriver driver;

    public NegativeLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");

    public void enterUsername(String username) {
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void negative(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
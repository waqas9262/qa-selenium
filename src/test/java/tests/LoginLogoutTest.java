package tests;

import core.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginLogoutTest extends BaseTest {

    @Test
    public void loginLogoutTest() {
        // Step 1: Open website
        driver.get("https://www.saucedemo.com/");

        // Type username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Type password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Click login
        driver.findElement(By.id("login-button")).click();

        // Click Hamburger menu
        driver.findElement(By.id("react-burger-menu-btn")).click();

        // Wait until logout link is clickable
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

        // Logout
        driver.findElement(By.id("logout_sidebar_link")).click();

    }
}
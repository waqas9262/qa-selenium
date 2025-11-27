package pages;

import core.LoggerManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Page Object for handling the checkout workflow.
public class CheckoutPage {

    private final WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By checkOutButton = By.id("checkout");
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");

    public void clickCheckout() {
        LoggerManager.getLogger().info("Clicking checkout button");
        driver.findElement(checkOutButton).click();
    }

    public void enterFirstname(String firstname) {
        LoggerManager.getLogger().info("Entering first name");
        driver.findElement(firstNameInput).sendKeys(firstname);
    }

    public void enterLastname(String lastname) {
        LoggerManager.getLogger().info("Entering last name");
        driver.findElement(lastNameInput).sendKeys(lastname);
    }

    public void enterPostcode(String postcode) {
        LoggerManager.getLogger().info("Entering postal code");
        driver.findElement(postalCodeInput).sendKeys(postcode);
    }

    public void clickContinue() {
        LoggerManager.getLogger().info("Clicking continue button");
        driver.findElement(continueButton).click();
    }

    public void clickFinish() {
        LoggerManager.getLogger().info("Clicking finish button");
        driver.findElement(finishButton).click();
    }

    // Executes the full checkout sequence.
    public void checkout(String firstname, String lastname, String postcode) {
        clickCheckout();
        enterFirstname(firstname);
        enterLastname(lastname);
        enterPostcode(postcode);
        clickContinue();
        clickFinish();
    }
}
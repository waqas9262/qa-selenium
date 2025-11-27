package pages;

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
        driver.findElement(checkOutButton).click();
    }

    public void enterFirstname(String firstname) {
        driver.findElement(firstNameInput).sendKeys(firstname);
    }

    public void enterLastname(String lastname) {
        driver.findElement(lastNameInput).sendKeys(lastname);
    }

    public void enterPostcode(String postcode) {
        driver.findElement(postalCodeInput).sendKeys(postcode);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickFinish() {
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
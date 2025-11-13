package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private final WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Checkout page elements
    private final By checkOutButton = By.id("checkout");
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");

    // Clicks the checkout button
    public void clickCheckout() {
        driver.findElement(checkOutButton).click();
    }

    // Enters user details
    public void enterFirstname(String firstname) {
        driver.findElement(firstNameInput).sendKeys(firstname);
    }

    public void enterLastname(String lastname) {
        driver.findElement(lastNameInput).sendKeys(lastname);
    }

    public void enterPostcode(String postcode) {
        driver.findElement(postalCodeInput).sendKeys(postcode);
    }

    // Navigates through checkout steps
    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    // Full checkout flow combined
    public void checkout(String firstname, String lastname, String postcode) {
        clickCheckout();
        enterFirstname(firstname);
        enterLastname(lastname);
        enterPostcode(postcode);
        clickContinue();
        clickFinish();
    }
}
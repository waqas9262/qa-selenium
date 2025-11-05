package tests;

import core.BaseTest;
import org.testng.annotations.Test;

public class OpenSiteTest extends BaseTest {

    @Test
    public void openSaucedemo() {
        // Open the site
        driver.get("https://www.saucedemo.com/");

    }
}
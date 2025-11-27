package tests;

import core.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.CSVReader;

public class DataDrivenLoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        // CSV file is at: src/test/resources/data/loginData.csv
        return CSVReader.readCSV("data/loginData.csv");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);

        System.out.println("Testing → " + username + " / " + password);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
}
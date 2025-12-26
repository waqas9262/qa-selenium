package core;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import core.ConfigManager;
import core.LoggerManager;
import com.aventstack.extentreports.ExtentTest;
import core.ExtentManager;


import java.util.HashMap;
import java.util.Map;

// Base test class providing browser setup and teardown for all tests.
public class BaseTest {
    protected WebDriver driver;
    protected static ExtentTest test;

    @BeforeMethod
    public void setUp() {

        test = ExtentManager.getReporter().createTest(this.getClass().getSimpleName());

        String browser = ConfigManager.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            // --- Added ChromeOptions to remove password popup and stabilize tests ---
            ChromeOptions options = new ChromeOptions();

            // Disable Chrome password manager popups
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            // Disable password leak detection popup
            options.addArguments("--disable-features=PasswordLeakDetection,PasswordCheck");

            // Optional: run in incognito to avoid saving data between runs
            options.addArguments("--incognito");
            if (ConfigManager.isHeadless()) {
                options.addArguments("--headless=new");
            }

            driver = new ChromeDriver(options);
            // ------------------------------------------------------------------------

        } else if (browser.equalsIgnoreCase("firefox")) {
            throw new RuntimeException("Firefox not supported yet");

        } else if (browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();

            EdgeOptions options = new EdgeOptions();
            options.addArguments("--incognito");
            if (ConfigManager.isHeadless()) {
                options.addArguments("--headless=new");
            }

            driver = new EdgeDriver(options);

        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        LoggerManager.getLogger().info("Browser started: " + browser);

        driver.manage().window().maximize();
        LoggerManager.getLogger().info("Navigating to: " + ConfigManager.getBaseUrl());
        driver.get(ConfigManager.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
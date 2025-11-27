package core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

// TestNG listener to integrate ExtentReports and screenshots.
public class ExtentTestListener implements ITestListener {

    private static final ExtentReports extent = ExtentManager.getReporter();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, result.getThrowable());

        Object instance = result.getInstance();
        if (instance instanceof BaseTest) {
            WebDriver driver = ((BaseTest) instance).driver;
            if (driver != null) {
                try {
                    String screenshotPath = takeScreenshot(driver, result.getMethod().getMethodName());
                    test.get().fail("Screenshot on failure",
                            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                } catch (Exception e) {
                    test.get().warning("Failed to attach screenshot: " + e.getMessage());
                }
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    private String takeScreenshot(WebDriver driver, String methodName) throws Exception {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotsDir = System.getProperty("user.dir") + "/screenshots";
        Files.createDirectories(Paths.get(screenshotsDir));

        String path = screenshotsDir + "/" + methodName + "_" + timeStamp + ".png";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src.toPath(), Paths.get(path));
        return path;
    }
}
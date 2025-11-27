package core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReporter() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir") + "/reports/extent-report.html";

            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("Automation Test Report");
            reporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }

        return extent;
    }
}
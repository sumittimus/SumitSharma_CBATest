package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    public static synchronized ExtentReports getExtentReports() {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/AutomationReport.html");
            spark.config().setDocumentTitle("API Test Report");
            extent.attachReporter(spark);
        }
        return extent;
    }

    public static synchronized void startTest(String testName) {
        ExtentTest test = getExtentReports().createTest(testName);
        testThread.set(test);
    }

    public static ExtentTest getTest() {
        return testThread.get();
    }

    public static synchronized void endTest() {
        testThread.remove();
    }

    public static synchronized void flushReports() {
        if (extent != null) extent.flush();
    }
}

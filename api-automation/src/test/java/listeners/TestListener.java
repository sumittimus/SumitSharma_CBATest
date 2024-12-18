package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentManager.startTest(testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Throwable t = result.getThrowable();
        if (t != null) {
            // Filter the stack trace
            StackTraceElement[] filteredStack = Arrays.stream(t.getStackTrace())
                .filter(element -> !element.getMethodName().equals("invoke0"))
                .toArray(StackTraceElement[]::new);
            
            t.setStackTrace(filteredStack);

            // Assuming you have a way to get the current ExtentTest instance
            ExtentTest test = ExtentManager.getTest(); // Custom method to get current test object
            test.fail(t);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getTest().skip("Test Skipped: " + result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flushReports();
    }
}

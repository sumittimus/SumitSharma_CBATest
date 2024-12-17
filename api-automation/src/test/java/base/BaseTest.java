package base;

import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ConfigLoader;
import utils.ExtentManager;
import utils.LoggerUtil;
import org.apache.logging.log4j.Logger;

public class BaseTest {

    private static final Logger logger = LoggerUtil.getLogger(BaseTest.class);
    private static final ThreadLocal<String> threadBaseURI = new ThreadLocal<>();

    @BeforeSuite
    public void suiteSetup() {
        logger.info("Initializing suite setup...");
        String baseUrl = ConfigLoader.get("base.url");
        RestAssured.baseURI = baseUrl;
        logger.info("Base URI set to: " + baseUrl);
    }

    @BeforeMethod
    public void setupTest() {
        threadBaseURI.set(RestAssured.baseURI);
        String testName = Thread.currentThread().getStackTrace()[2].getMethodName();
        ExtentManager.startTest(testName);
    }

    @AfterMethod
    public void teardownTest() {
        threadBaseURI.remove();
        ExtentManager.endTest();
    }

    public static String getBaseUri() {
        return threadBaseURI.get();
    }
}

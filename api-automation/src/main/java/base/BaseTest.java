// Initializes global configurations and setup for all tests.
//It serves as a central place to initialize and configure common setup or tear down activities required for test execution.

package base;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;

import utils.ConfigLoader;
import utils.LoggerUtil;

//Initializes global configurations and setup for all tests.
public class BaseTest {
	private static final Logger logger = LoggerUtil.getLogger(BaseTest.class);

    @BeforeSuite
    public void setup() {
        logger.info("Initializing test suite setup...");
        String baseUrl = ConfigLoader.get("base.url");
        logger.info("Base URL loaded from config: " + baseUrl);
    }


}

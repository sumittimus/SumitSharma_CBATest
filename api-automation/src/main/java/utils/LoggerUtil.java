package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Utility class to get and configure loggers.

public class LoggerUtil {

	    // Get a logger instance
	    public static Logger getLogger(Class<?> loggerClass) {
	        return LogManager.getLogger(loggerClass);
	    }
}


package utils;

import java.io.FileInputStream;
import java.util.Properties;

//Loads properties from config.properties for configuration management.
public class ConfigLoader {
	
	private static Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }


}

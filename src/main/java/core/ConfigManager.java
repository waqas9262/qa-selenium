package core;

import java.util.Properties;

// Loads config.properties once and provides access to its values.
public class ConfigManager {

    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(ConfigManager.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties"));
        } catch (Exception e) {
            throw new RuntimeException("Could not load config.properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        return get("base.url");
    }

    public static String getUsername() {
        return get("username");
    }

    public static String getPassword() {
        return get("password");
    }

    public static String getBrowser() {
        return get("browser");
    }
}
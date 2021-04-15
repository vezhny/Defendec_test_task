package core.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@Slf4j
public final class PropertiesProvider {
    private Properties config;
    private static volatile PropertiesProvider instance;

    /** Property name: using selenium browser */
    private static final String SELENIUM_BROWSER_PROPERTY_NAME = "selenium.browser";

    /** Property name: selenium base page url */
    private static final String SELENIUM_BASE_URL_PROPERTY_NAME = "selenium.base.url";

    /** Property name: user login */
    private static final String USER_LOGIN_PROPERTY_NAME = "user.login";

    /** Property name: user password */
    private static final String USER_PASSWORD_PROPERTY_NAME = "user.password";

    private PropertiesProvider() {
        config = new Properties();
        try {
            getConfig();
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

    private void getConfig() throws IOException {
        try (BufferedReader configPropertiesReader = new BufferedReader(new InputStreamReader(getClass()
                .getResourceAsStream("/config.properties"), StandardCharsets.UTF_8))) {
            config.load(configPropertiesReader);
        }
    }

    /**
     * Singleton
     * @return - instance
     */
    private static PropertiesProvider getInstance() {
        PropertiesProvider localInstance = instance;
        if (localInstance == null) {
            synchronized (PropertiesProvider.class) {
                localInstance = instance;
                if (instance == null) {
                    localInstance = instance = new PropertiesProvider();
                }
            }
        }
        return localInstance;
    }

    /**
     * Gets using browser for selenium tests
     * @return using browser name
     */
    public static String getSeleniumBrowser() {
        return getPropertyValue(SELENIUM_BROWSER_PROPERTY_NAME);
    }

    /**
     * Gets start page url for selenium tests
     * @return start page url
     */
    public static String getSeleniumBaseUrl() {
        return getInstance().config.getProperty(SELENIUM_BASE_URL_PROPERTY_NAME);
    }

    public static String getUserLogin() {
        return getInstance().config.getProperty(USER_LOGIN_PROPERTY_NAME);
    }

    public static String getUserPassword() {
        return getInstance().config.getProperty(USER_PASSWORD_PROPERTY_NAME);
    }

    /**
     * Try to get property from system variable
     * If fail, get property from config.properties
     * @param propertyName - needed property name
     * @return - property value
     */
    private static String getPropertyValue(String propertyName) {
        String value = System.getProperty(propertyName);
        if (value == null) {
            log.debug("Property \"" + propertyName + "\" is absent in environment variables");
            return getInstance().config.getProperty(propertyName);
        }
        return value;
    }
}

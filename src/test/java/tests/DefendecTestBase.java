package tests;

import core.config.DriverManager;
import core.config.PropertiesProvider;
import io.qameta.allure.Allure;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@Slf4j
public abstract class DefendecTestBase {

    protected static WebDriver webDriver;

    @BeforeAll
    public static void setUp() {
        webDriver = DriverManager.getWebDriver();
        webDriver.get(PropertiesProvider.getSeleniumBaseUrl());
    }

    @BeforeEach
    public void beforeTest(TestInfo testInfo) {
        log.info("--------------- Start Test ---------------");
        log.info("TEST NAME: " + testInfo.getDisplayName());
        Allure.description(testInfo.getDisplayName());
    }

    @AfterEach
    public void afterTest() {
        log.info("--------------- End Test ---------------\n");
    }

    @AfterAll
    public static void shutDown() {
        webDriver.close();
    }
}

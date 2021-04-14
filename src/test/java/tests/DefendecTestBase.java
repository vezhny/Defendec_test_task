package tests;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

@Slf4j
public abstract class DefendecTestBase {

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
}

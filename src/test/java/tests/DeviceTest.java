package tests;

import core.steps.LoginSteps;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

@Feature("Device")
public class DeviceTest extends DefendecTestBase {

    private LoginSteps loginSteps = new LoginSteps(webDriver);

    @Test
    public void first() {
        loginSteps.login();
    }
}

package tests;

import core.steps.EventSteps;
import core.steps.LoginSteps;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

@Feature("Device")
public class DeviceTest extends DefendecTestBase {

    private LoginSteps loginSteps = new LoginSteps(webDriver);
    private EventSteps eventSteps = new EventSteps(webDriver);

    @Test
    public void first() {
        loginSteps.login();
        eventSteps.getLastEvent();
    }
}

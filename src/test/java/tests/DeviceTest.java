package tests;

import core.steps.DeviceSteps;
import core.steps.EventSteps;
import core.steps.LoginSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

@Feature("Device")
public class DeviceTest extends DefendecTestBase {

    private LoginSteps loginSteps = new LoginSteps(webDriver);
    private EventSteps eventSteps = new EventSteps(webDriver);
    private DeviceSteps deviceSteps = new DeviceSteps(webDriver);

    @Story("Connection range")
    @Test
    public void test() {
        loginSteps.login();
        eventSteps.getLastEvent();
        eventSteps.clickDeviceName();
        String deviceId = deviceSteps.getDeviceId();
        deviceSteps.getToDevices();
        deviceSteps.getLastConnectionTime(deviceId);
    }
}

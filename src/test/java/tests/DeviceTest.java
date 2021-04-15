package tests;

import core.steps.DeviceSteps;
import core.steps.EventSteps;
import core.steps.LoginSteps;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

@Feature("Device")
public class DeviceTest extends DefendecTestBase {

    private LoginSteps loginSteps = new LoginSteps(webDriver);
    private EventSteps eventSteps = new EventSteps(webDriver);
    private DeviceSteps deviceSteps = new DeviceSteps(webDriver);

    @Test
    public void first() {
        loginSteps.login();
        eventSteps.getLastEvent();
//        LocalDateTime eventTimeStamp = eventSteps.getLastEventTimestamp();
        eventSteps.clickDeviceName();
        String deviceId = deviceSteps.getDeviceId();
        deviceSteps.getToDevices();
        deviceSteps.getLastConnectionTime(deviceId);
    }
}

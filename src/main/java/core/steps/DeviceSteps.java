package core.steps;

import core.config.PropertiesProvider;
import core.pages.DevicePage;
import core.pages.DevicesPage;
import core.pages.NavigationBar;
import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;

public class DeviceSteps extends BaseStep{

    private DevicePage devicePage;
    private DevicesPage devicesPage;
    private NavigationBar navigationBar;

    public DeviceSteps(WebDriver webDriver) {
        super(webDriver);
        devicePage = new DevicePage(webDriver);
        devicesPage = new DevicesPage(webDriver);
        navigationBar = new NavigationBar(webDriver);
    }

    @Step("Get device id")
    public String getDeviceId() {
        return devicePage.getDeviceId();
    }

    @Step("Get to devices")
    public void getToDevices() {
        navigationBar.selectItem("Devices");
    }

    public void getLastConnectionTime(String deviceId) {
        LocalDateTime lastConnectionTime = devicesPage.getDeviceLastConnection(deviceId);
        checkLastConnectionInterval(lastConnectionTime);
    }

    @Step("Check last connection time")
    private void checkLastConnectionInterval(LocalDateTime lastConnectionTime) {
        LocalDateTime now = LocalDateTime.now().minusMinutes(Long.parseLong(PropertiesProvider.getDeviceConnectionInterval()));
        Assertions.assertTrue(lastConnectionTime.isAfter(now), "Last connection date is too far");
    }
}

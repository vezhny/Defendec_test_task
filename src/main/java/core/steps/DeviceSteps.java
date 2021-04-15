package core.steps;

import core.pages.DevicePage;
import core.pages.DevicesPage;
import core.pages.NavigationBar;
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

    public String getDeviceId() {
        return devicePage.getDeviceId();
    }

    public void getToDevices() {
        navigationBar.selectItem("Devices");
    }

    public LocalDateTime getLastConnectionTime(String deviceId) {
        return devicesPage.getDeviceLastConnection(deviceId);
    }
}

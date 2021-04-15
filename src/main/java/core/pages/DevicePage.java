package core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DevicePage extends PageBase{

    @FindBy(xpath = "//*[contains(text(), 'Device ID')]")
    private WebElement deviceId;

    public DevicePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public DevicePage load() {
        waitFor(ExpectedConditions.visibilityOfAllElements(deviceId));
        return this;
    }

    public String getDeviceId() {
        return deviceId.getText().replaceAll("Device ID: ", "");
    }
}

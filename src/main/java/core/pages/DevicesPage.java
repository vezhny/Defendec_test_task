package core.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Slf4j
public class DevicesPage extends PageBase{

    @FindBy(xpath = "//datatable-header-cell")
    private List<WebElement> headerCells;

    @FindBy(xpath = "//datatable-row-wrapper")
    private List<WebElement> devices;

    public DevicesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public DevicesPage load() {
        waitFor(ExpectedConditions.visibilityOfAllElements(devices));
        return this;
    }

    public LocalDateTime getDeviceLastConnection(String deviceId) {
        log.debug("Searching device with id " + deviceId);
        for (WebElement device : devices) {
            log.debug(device.getText());
            if (device.findElement(By.xpath(".//*[contains(@href, '/device/')]")).getText().equals(deviceId)) {
                String lastConnectionDate = device.findElement(By.xpath(".//*/datatable-body-cell[9]/div")).getText();
                return LocalDateTime.parse(lastConnectionDate, DateTimeFormatter.ofPattern("HH:mm dd-MMM-yyyy", Locale.US));
            }
        }
        throw new RuntimeException("Device with id \"" + deviceId + "\" not found");
    }

    private int getColumnNumberOf(String columnName) {
        for (WebElement cell : headerCells) {
            if (cell.getAttribute("title").equals(columnName)) {
                return headerCells.indexOf(cell);
            }
        }
        throw new  RuntimeException("Unable to find header cell with title \"" + columnName + "\"");
    }
}

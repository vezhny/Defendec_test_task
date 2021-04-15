package core.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EventPage extends PageBase {

    @Getter
    @FindBy(xpath = "//*[@class='detail-time']")
    private WebElement time;

    @Getter
    @FindBy(xpath = "//*[@class='detail-date']")
    private WebElement date;

    @FindBy(xpath = "//*[contains(@class, 'detail-device-name')]")
    private WebElement device;

    public EventPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public EventPage load() {
        waitFor(ExpectedConditions.visibilityOfAllElements(time, date, device));
        return this;
    }

    public EventPage deviceClick() {
        device.click();
        return this;
    }
}

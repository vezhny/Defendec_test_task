package core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EventPage extends PageBase {

    @FindBy(xpath = "//*[@class='detail-time']")
    private WebElement time;

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
}

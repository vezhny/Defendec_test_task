package core.pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Getter
public class EventsPage extends PageBase {

    private NavigationBar navigationBar;
    private FilterMenu filterMenu;

    @FindBy(xpath = "//*[contains(@id, 'group')]")
    private List<WebElement> events;

    public EventsPage(WebDriver webDriver) {
        super(webDriver);
        navigationBar = new NavigationBar(webDriver);
        filterMenu = new FilterMenu(webDriver);
    }

    @Override
    public EventsPage load() {
        navigationBar.load();
        filterMenu.load();
        waitFor(ExpectedConditions.visibilityOfAllElements(events));
        return this;
    }

    public EventsPage selectEventNumber(int number) {
        events.get(number - 1).click();
        return this;
    }
}

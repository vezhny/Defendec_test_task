package core.pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class EventsPage extends PageBase {

    private NavigationBar navigationBar;
    private FilterMenu filterMenu;

    public EventsPage(WebDriver webDriver) {
        super(webDriver);
        navigationBar = new NavigationBar(webDriver);
        filterMenu = new FilterMenu(webDriver);
    }

    @Override
    public EventsPage load() {
        navigationBar.load();
        filterMenu.load();
        return this;
    }
}

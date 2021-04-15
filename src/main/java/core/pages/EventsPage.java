package core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EventsPage extends PageBase {

    private NavigationBar navigationBar;
    private FilterMenu filterMenu;

    public EventsPage(WebDriver webDriver) {
        super(webDriver);
        navigationBar = new NavigationBar(webDriver);
        filterMenu = new FilterMenu(webDriver);
    }

    @Override
    public PageBase load() {
        navigationBar.load();
        filterMenu.load();
        return this;
    }
}

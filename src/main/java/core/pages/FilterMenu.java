package core.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FilterMenu extends PageBase {

    @FindBy(xpath = ".//*[@class='menu-block']/div")
    private List<WebElement> filters;

    public FilterMenu(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public FilterMenu load() {
        waitFor(ExpectedConditions.visibilityOfAllElements(filters));
        return this;
    }

    public List<WebElement> getSelectedFilters() {
        log.debug("Getting selected filters");
        List<WebElement> selectedFilters = new ArrayList<>();
        for (WebElement filter : filters) {
            if (!filter.getCssValue("background").equals("#356b7d!important")) {
                log.debug("Selected filter " + filter);
                selectedFilters.add(filter);
            }
        }
        return selectedFilters;
    }
}

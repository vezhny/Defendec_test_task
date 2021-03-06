package core.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Slf4j
public class NavigationBar extends PageBase {

    @FindBy(xpath = ".//*[@id='main-menu']/a")
    private List<WebElement> menuItems;

    public NavigationBar(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public NavigationBar load() {
        waitFor(ExpectedConditions.visibilityOfAllElements(menuItems));
        return this;
    }

    public WebElement getSelectedItem() {
        log.debug("Getting selected item from navi bar");
        for (WebElement item : menuItems) {
            if (item.getCssValue("color").equals("rgba(255, 255, 255, 1)")) {
                log.debug("Selected item is " + item.getText());
                return item;
            }
        }
        throw new RuntimeException("Unable to get selected item from navigation bar");
    }

    public NavigationBar selectItem(String itemName) {
        for (WebElement item : menuItems) {
            if (item.getText().contains(itemName)) {
                item.click();
                return this;
            }
        }
        throw new RuntimeException("Unable to get item \"" + itemName + "\" from navigation bar");
    }
}

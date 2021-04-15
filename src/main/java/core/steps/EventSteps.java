package core.steps;

import core.pages.EventsPage;
import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class EventSteps extends BaseStep {

    private EventsPage eventsPage;

    public EventSteps(WebDriver webDriver) {
        super(webDriver);
        eventsPage = new EventsPage(webDriver);
    }

    public void getLastEvent() {
        eventsPage.load();
        eventsPage.getNavigationBar().getSelectedItem();
        eventsPage.getFilterMenu().getSelectedFilters();
        checkNavigationBarItem("Events");
        checkSelectedFilters("Maintenance events");
        eventsPage.selectEventNumber(1);
    }

    @Step("Check selected navigation bar item is \"{0}\"")
    private void checkNavigationBarItem(String expectedItem) {
        MatcherAssert.assertThat("Selected item in navi bar is " + expectedItem,
                eventsPage.getNavigationBar().getSelectedItem().getText(), Matchers.containsString(expectedItem));
    }

    @Step("Check, that selected filters are {0}")
    private void checkSelectedFilters(String... expectedFilters) {
        List<String> selectedFilters = eventsPage.getFilterMenu().getSelectedFilters();
        Assertions.assertEquals(expectedFilters.length, selectedFilters.size(),
                "Selected filters count mismatch");
        MatcherAssert.assertThat(Arrays.asList(expectedFilters), Matchers.containsInAnyOrder(selectedFilters.toArray()));
    }
}

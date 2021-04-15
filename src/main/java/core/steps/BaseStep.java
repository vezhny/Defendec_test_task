package core.steps;

import core.config.PropertiesProvider;
import org.openqa.selenium.WebDriver;

public abstract class BaseStep {

    protected WebDriver webDriver;

    public BaseStep(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void start() {
        webDriver.get(PropertiesProvider.getSeleniumBaseUrl());
    }
}

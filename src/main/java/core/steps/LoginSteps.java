package core.steps;

import core.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver webDriver;
    private LoginPage loginPage;

    public LoginSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
        loginPage = new LoginPage(webDriver);
    }

    public void login() {
        loginPage.enterLogin()
    }
}

package core.steps;

import core.config.PropertiesProvider;
import core.pages.LoginPage;
import core.pages.PageBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginSteps extends BaseStep{

    private LoginPage loginPage;

    public LoginSteps(WebDriver webDriver) {
        super(webDriver);
        loginPage = new LoginPage(webDriver);
    }

    @Step("Log in")
    public void login() {
        String login = PropertiesProvider.getUserLogin();
        String password = PropertiesProvider.getUserPassword();
        Allure.parameter("Login", login);
        Allure.parameter("Password", password);
        loginPage
                .load()
                .enterLogin(login)
                .enterPassword(password)
                .clickLoginButton();
    }
}

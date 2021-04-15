package core.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class LoginPage extends PageBase {

    @FindBy(id = "id2")
    private WebElement loginTextField;

    @FindBy(id = "id3")
    private WebElement passwordTextField;

    @FindBy(xpath = ".//@id='submit-row'/input")
    private WebElement logInButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public LoginPage load() {
        waitFor(ExpectedConditions.visibilityOfAllElements(loginTextField, passwordTextField, logInButton));
        return this;
    }

    public LoginPage enterLogin(String login) {
        getLoginTextField().sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        getPasswordTextField().sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        getLogInButton().click();
        return this;
    }
}

package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement usernameField = $("[name='username']"),
            passwordField = $("[name='password']"),
            loginButton = $("[value='Login']"),
            loginPageTitle = $("h1"),
            noAccountFoundError = $(byText("No account found with that username.")),
            pleaseEnterYourUsernameError = $(byText("Please enter username.")),
            pleaseEnterYourPasswordError = $(byText("Please enter your password."));

    @Step("Input username: {username}")
    public LoginPage inputUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
        return this;
    }

    @Step("Input password: {password}")
    public LoginPage inputPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Click Login button")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }
}

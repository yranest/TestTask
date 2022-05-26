package verify;

import io.qameta.allure.Step;
import page.LoginPage;

import static com.codeborne.selenide.Condition.text;

public class LoginPageVerify {

    LoginPage loginPage = new LoginPage();

    @Step("Verify username field is present")
    public LoginPageVerify verifyUsernameFieldIsPresent() {
        assert loginPage.usernameField.isDisplayed();
        return this;
    }

    @Step("Verify password field is present")
    public LoginPageVerify verifyPasswordFieldIsPresent() {
        assert loginPage.passwordField.isDisplayed();
        return this;
    }

    @Step("Verify Login button is present")
    public LoginPageVerify verifyLoginButtonIsDisplayed() {
        assert loginPage.loginButton.isDisplayed();
        return this;
    }

    @Step("Verify login page title is present and have text:{titleText}")
    public LoginPageVerify verifyLoginPageTitleText(String titleText) {
        assert loginPage.loginPageTitle.isDisplayed();
        loginPage.loginPageTitle.shouldHave(text(titleText));
        return this;
    }

    @Step("Verify 'No account found with that username' error is displayed")
    public LoginPageVerify verifyNoAccountFoundErrorMessage() {
        assert loginPage.noAccountFoundError.isDisplayed();
        return this;
    }

    @Step("Verify 'Please enter username' error is displayed")
    public LoginPageVerify verifyPleaseEnterUsernameErrorMessage() {
        assert loginPage.pleaseEnterYourUsernameError.isDisplayed();
        return this;
    }

    @Step("Verify 'please enter password' error is displayed")
    public LoginPageVerify verifyPleaseEnterPasswordErrorMessage() {
        assert loginPage.pleaseEnterYourPasswordError.isDisplayed();
        return this;
    }
}

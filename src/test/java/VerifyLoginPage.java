import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import verify.LoginPageVerify;


public class VerifyLoginPage {

    private static final String LOGIN_PAGE_TITLE = "AQA internship Login";
    private LoginPage loginPage;
    private LoginPageVerify loginPageVerify;

    @BeforeMethod
    public void doPreconditionSteps() {
        Selenide.open("https://www.pecodesoftware.com/qa-portal/registerlogin/registerlogin.php");
        loginPage = new LoginPage();
        loginPageVerify = new LoginPageVerify();
    }

    @Test
    public void verifyLoginPage() {
        loginPageVerify.verifyUsernameFieldIsPresent();
        loginPageVerify.verifyPasswordFieldIsPresent();
        loginPageVerify.verifyLoginButtonIsDisplayed();
        loginPageVerify.verifyLoginPageTitleText(LOGIN_PAGE_TITLE);

        loginPage.inputUsername("username");
        loginPage.inputPassword("username");
        loginPage.clickLoginButton();
    }

    @Test
    public void verifyLoginPageErrors() {
        loginPage.clickLoginButton();
        loginPageVerify.verifyPleaseEnterPasswordErrorMessage();
        loginPageVerify.verifyPleaseEnterUsernameErrorMessage();

        loginPage.inputUsername("username");
        loginPage.inputPassword("username");
        loginPage.clickLoginButton();
        loginPageVerify.verifyNoAccountFoundErrorMessage();
    }

}

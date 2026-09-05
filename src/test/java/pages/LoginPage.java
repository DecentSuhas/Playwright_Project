package pages;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import utils.AssertionUtils;
import utils.BaseMethods;

public class LoginPage {

    private BaseMethods baseMethods;
    private final String usernameField = "input[id=\"user-name\"]";
    private final String passwordField = "input[id=\"password\"]";
    private final String loginButton = "input[type=\"submit\"]";
    private final String errorMessage = "[data-test=\"error\"]";
    AssertionUtils assertionUtils;

    public LoginPage(Page page){
        baseMethods = new BaseMethods(page);
        assertionUtils = new AssertionUtils(page);

    }

    public void enterUsername(String username){
        baseMethods.enterTextToInput(usernameField, username);
    }

    public void enterPassword(String password){
        baseMethods.enterTextToInput(passwordField, password);
    }

    public void clickLoginButton(){
        baseMethods.clickElement(loginButton);
    }

    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void verifyErrorMessage(){
        String text = baseMethods.getElementText(errorMessage);
        assertionUtils.verifyText(text,"Epic sadface: Username and password do not match any user in this service" );
    }
}

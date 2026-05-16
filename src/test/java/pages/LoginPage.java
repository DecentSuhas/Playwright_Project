package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;
    private final String usernameField = "input[id=\"user-name\"]";
    private final String passwordField = "input[id=\"password\"]";
    private final String loginButton = "input[type=\"submit\"]";

    public LoginPage(Page page){
        this.page=page;
    }

    public void enterUsername(String username){
        page.fill(usernameField, username);
    }

    public void enterPassword(String password){
        page.fill(passwordField, password);
    }

    public void clickLoginButton(){
        page.click(loginButton);
    }

    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();

    }
}

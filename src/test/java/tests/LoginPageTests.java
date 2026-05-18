package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTests extends BaseTest {

    @Test
    public void verifyLoginInvalidUser(){
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("standard_user", "secret_sauce124");
        loginPage.verifyErrorMessage();

    }




}


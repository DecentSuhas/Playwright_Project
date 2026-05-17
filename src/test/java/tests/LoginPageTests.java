package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTests extends BaseTest {

    @Test
    public void verifyLoginInvalidUser(){
        extentTest.info("Login to the application");
        LoginPage loginPage = new LoginPage(page);
        page.navigate("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce124");
        loginPage.verifyErrorMessage();

    }




}


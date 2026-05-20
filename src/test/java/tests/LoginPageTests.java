package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class LoginPageTests extends BaseTest {

 //   @Test( retryAnalyzer = listeners.RetryAnalyzer.class )
    public void verifyLoginInvalidUser(){
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("standard_user", "secret_sauce124");
        loginPage.verifyErrorMessage();

    }
    @Test( retryAnalyzer = listeners.RetryAnalyzer.class )
    public void verifyLoginValidUser(){
        LoginPage loginPage = new LoginPage(page);
        ProductPage productPage = new ProductPage(page);
        loginPage.login("standard_user", "secret_sauce");
        productPage.verifyPageTitle();

    }



}


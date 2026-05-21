package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import utils.TestDataProvider;

public class LoginPageTests extends BaseTest {

    @Test(  dataProvider = "loginData",
            dataProviderClass = TestDataProvider.class,
            retryAnalyzer = listeners.RetryAnalyzer.class )
    public void verifyLoginInvalidUser(String username, String password){
        LoginPage loginPage = new LoginPage(page);
        loginPage.login(username, password);
        loginPage.verifyErrorMessage();

    }
//    @Test(retryAnalyzer = listeners.RetryAnalyzer.class )
    public void verifyLoginValidUser(){
        LoginPage loginPage = new LoginPage(page);
        ProductPage productPage = new ProductPage(page);
        loginPage.login("standard_user", "secret_sauce");
        productPage.verifyPageTitle();

    }



}


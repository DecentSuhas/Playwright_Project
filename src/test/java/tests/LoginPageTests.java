package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class LoginPageTests extends BaseTest {

    @Test
    public void verifyLogin(){
        extentTest.info("Login to the application");

        LoginPage loginPage = new LoginPage(page);
        ProductPage productPage = new ProductPage(page);
        page.navigate("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce124");
        productPage.verifyPageTitle();

    }

}


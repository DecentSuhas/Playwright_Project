package refer;

import com.microsoft.playwright.*;

import java.util.List;

public class CreateElements {

    public static void main(String [] args){

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions());

        Page page = browser.newPage();

        page.navigate("https://www.orangehrm.com/en/30-day-free-trial");

        // Locator in playwright refers to webelement itself. Not like locators in Selenium

        // Single element
        Locator contactSales = page.locator("text=Contact Sales");  // Use text= only if it is unique text
        contactSales.hover();
        contactSales.click();

        // Multiple element approach 1
        Locator loginBtn = page.locator("text=Login");
        int totalLoginBtn = loginBtn.count();
        loginBtn.first().click();


        // Multiple element approach 2
        Locator countryList = page.locator("select#Form_submitForm_Country option");
        List<String> countries = countryList.allTextContents();
        for(String country : countries){
            System.out.println(country);
        }

    }
}

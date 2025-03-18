package basics;

import com.microsoft.playwright.*;

public class PlaywrightSelectors {

    public static void main(String [] args){

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions());

        Page page = browser.newPage();

        page.navigate("https://www.orangehrm.com/en/30-day-free-trial");


        Locator links = page.locator("text=Privacy policy");
        for(int i=0; i<links.count();i++){
            System.out.println(links.nth(i).textContent());
            if(links.nth(i).textContent().contains("Privacy policy")){
                links.nth(i).click();
            }
        }


        //<div class="well">
        //  <h2>New customer</h2>
        //</div>
        Locator customer1 = page.locator("h2:has-text('New customer')"); // or "div.well h2:has-text('New customer')"
        String getText = customer1.textContent();
        System.out.println(getText);


        //<h1>
        //  <a href="https://abcd">Your Store</a>
        //</h1>
        String yourStore = page.locator("'Your Store'").textContent(); // When you dont want to mention "text="Your Store" then add single quotes
        System.out.println(yourStore);


        //<form method="post"
        // <input type="submit" value="Login" </input>
        //</form>

        page.locator("form input:has-text('Login')").click();

    }
}

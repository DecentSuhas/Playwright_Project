package basics;

import com.microsoft.playwright.*;

import java.util.List;

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


        // When an element has another element
        // E.g. select tag has option tag with country name
        page.locator("select#Form_submitForm_Country:has(option[value='India'])").click();
        // parent tag :has child element
        Locator amazonFooterList = page.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs/])");
        List<String> getLinks = amazonFooterList.allTextContents();
        for(String text : getLinks){
            System.out.println(text);
        }


        // With multiple selectors
        page.locator("span:has-text('SignIn'), span:has-text('LogIn'), span:has-text('Login')").click();
        Locator import_items = page.locator("span:has-text('SignIn'), span:has-text('Store'), a:has-text('EXPLORE COURSES')");
        System.out.println(import_items.count()); // >> Identifies 3 elements



        // XPATH Union - Here | operator is used to combine 2 expaths.
        page.locator("//span[text(), 'SignIn'] | //span[text(), 'LogIn']").click();


        // Relative CSS Selector
        // www.selectorshub.com/xpath-practice-page/
        page.locator("input[type='checkbox']:left-of(:text['Joe.Root']))").first().click();
        String username = "Jasmine.Morgan";
        page.locator("input[type='checkbox']:left-of(:text['"+username+"']))").first().click();
        page.locator("td:right-of(:text('Joe.Root'))").textContent();
        page.locator("a:above(:text('Joe.Root')").first().textContent();
        page.locator("a:below(:text('Joe.Root')").first().textContent();
        Locator tds = page.locator("td:near(:text('Joe.Root'), 400"); // 400 is pixels
        List<String> getAlltds = tds.allInnerTexts();

        page.locator("input:below(label:text('Full Name')").first().fill("Ana");
        page.locator("input:below(label:text('Email')").first().fill("Ana.de.aramas@gmail.com");
        page.locator("input:below(label:text('Phone number')").first().fill("9988776655");

        page.locator("input:near(:text('Newsletter')").first().fill("Ana.de.aramas@gmail.com");

        page.locator("span.price.product-price:below(:text('Faded short sleeve T-shirts'))").first().innerText().trim();


    }
}

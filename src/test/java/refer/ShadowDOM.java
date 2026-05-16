package refer;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDOM {

    public static void main(String [] args){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions());
        Page page = browser.newPage();

        // You can automate showdoDOM only if #shadow-root (open)

        // Use case 1: Page DOM >> Shadow DOM >> Elements
        // Use case 2: Page DOM >> iFrame >> Shadow DOM >> Elements

        page.navigate("https://books-pwakit.appspot.com");
        page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing Books");
        String text = page.locator("book-app[apptitle='BOOKS'] .book-desc").textContent();
        System.out.println(text);


        Page page2 = browser.newPage();
        page2.navigate("https://selectorshub.com/xpath-practice-page/");
        page2.frameLocator("#pact").locator("div#snacktime #tea").fill("Ginger Masala Tea");


    }
}

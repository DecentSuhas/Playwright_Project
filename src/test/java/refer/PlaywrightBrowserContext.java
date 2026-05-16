package refer;

import com.microsoft.playwright.*;

public class PlaywrightBrowserContext {

    // n Number of contexts can be opened

    public static void main(String [] args){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        BrowserContext browserContext_1 = browser.newContext();
        Page page_1 = browserContext_1.newPage();
        page_1.navigate("https://www.orangehrm.com/en/30-day-free-trial");
        page_1.fill("#Form_getForm_subdomain", "suhas");
        System.out.println(page_1.title());


        BrowserContext browserContext_2 = browser.newContext();
        Page page_2 = browserContext_2.newPage();
        page_2.navigate("http://www.automationpractice.pl/index.php");
        page_2.fill("#search_query_top", "Dress");
        System.out.println(page_2.title());

        page_1.close();
        browserContext_1.close();

        page_2.close();
        browserContext_2.close();

    }
}

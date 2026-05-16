package refer;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class PlaywrightBasics {

    //mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen amazon.in"
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();

            context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));


            Page page = context.newPage();
            page.navigate("https://www.amazon.in/");
            page.getByRole(AriaRole.SEARCHBOX, new Page.GetByRoleOptions().setName("Search Amazon.in")).click();
            page.getByRole(AriaRole.SEARCHBOX, new Page.GetByRoleOptions().setName("Search Amazon.in")).fill("laptop");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Go").setExact(true)).click();
            Page page1 = page.waitForPopup(() -> {
                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sponsored Ad - HP 15s, 12th")).first().click();
            });
            page1.navigate("https://www.amazon.in/HP-i5-1235U-FY5008TU-Anti-Glare-15-6-inch/dp/B0CJM5Z6FY/ref=sr_1_2_sspa?crid=12NJ1FWWJE4PD&dib=eyJ2IjoiMSJ9.MfHz3q9pnA66f3PY92CaH3grZbQta6yAAVr85BSk3VsOdXeAkOFHDi5NLhzmxFTvFIFqe6gnNUW1fhSrCw0IWhmCwapdn_Yo0-dg_d-K81xpdCM6lbdyrFycB-wQu0ATEtcaB_pgXY6xJhurp3jELY4odSXtvUAsTutHdcd-N0Wrt5m_jGv9ir6I73hPfKxVQUISrtOVECkovfJfSG0d6yAtnVhKnVzV9uEq8poI5XY.7sd0a-X2rHbbtWy8WNaxvkXhlPtg3TtTBo0WNNlOgsQ&dib_tag=se&keywords=laptop&qid=1742202292&sprefix=laptop%2Caps%2C237&sr=8-2-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");

            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));

        }
    }
}

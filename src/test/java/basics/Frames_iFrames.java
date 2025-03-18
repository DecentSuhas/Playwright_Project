package basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Frames_iFrames {

    public static void main(String [] args){

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions());

        Page page = browser.newPage();

        // For frame

        page.navigate("https://www.londonfreelance.org/courses/frames/index.html");

        String header = page.frameLocator("frame[name='main']").locator("h2").textContent(); // CSS - For xpath "//frame[@name='main']
        System.out.println(header);

        String h2 = page.frame("main").locator("h2").textContent();
        System.out.println(h2);


        // For iFrame
        Page page2 = browser.newPage();
        page2.navigate("https://www.formsite.com/templates/registration-form-templates/club-registration-signup-form/");

        page2.locator("imag[title='club-signup-forms']").click();
        page2.frameLocator("iframe[contains(@id, 'frame-one')]").locator("#RESULT_TextField-8").fill("Suhas");


    }
}

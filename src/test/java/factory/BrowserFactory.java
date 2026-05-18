package factory;

import com.microsoft.playwright.*;
import config.ConfigReader;

public class BrowserFactory {

    private static ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();

    private static ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();

    private static ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();


    public static void initBrowser() {

        playwrightThreadLocal.set(Playwright.create());

        String browserName = ConfigReader.getProperty("browser");

        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));

        int slowMo = Integer.parseInt(ConfigReader.getProperty("slowmo"));

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                        .setHeadless(headless)
                        .setSlowMo(slowMo);

        Browser browser;

        switch (browserName.toLowerCase()) {

            case "firefox":

                browser = playwrightThreadLocal.get()
                        .firefox()
                        .launch(options);
                break;

            case "webkit":

                browser = playwrightThreadLocal.get()
                        .webkit()
                        .launch(options);
                break;

            case "chromium":

            default:

                browser = playwrightThreadLocal.get()
                        .chromium()
                        .launch(options);
                break;
        }

        browserThreadLocal.set(browser);

        Page page = browser.newPage();

        page.navigate(ConfigReader.getProperty("base.url"));

        pageThreadLocal.set(page);
    }


    public static Page getPage() {
        return pageThreadLocal.get();
    }


    public static Browser getBrowser() {
        return browserThreadLocal.get();
    }


    public static Playwright getPlaywright() {
        return playwrightThreadLocal.get();
    }


    public static void tearDown() {

        if (pageThreadLocal.get() != null) {
            pageThreadLocal.get().close();
        }

        if (browserThreadLocal.get() != null) {
            browserThreadLocal.get().close();
        }

        if (playwrightThreadLocal.get() != null) {
            playwrightThreadLocal.get().close();
        }
    }
}

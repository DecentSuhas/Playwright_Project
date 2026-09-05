package factory;

import com.microsoft.playwright.*;
import config.ConfigReader;

public class BrowserFactory {

    private static ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();

    private static ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();

    private static ThreadLocal<BrowserContext> contextThreadLocal = new ThreadLocal<>();

    private static ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();


    public static void initBrowser(String browserName, String execution     ) {

        if(browserName == null || browserName.isEmpty()) {
            browserName =ConfigReader.getProperty("browser");
        }

        playwrightThreadLocal.set(Playwright.create());

        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));

        int slowMo = Integer.parseInt(ConfigReader.getProperty("slowmo"));

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                        .setHeadless(headless)
                        .setSlowMo(slowMo);

        Browser browser;

        if(execution.equalsIgnoreCase(
                "browserstack")) {

            browser = BrowserStackFactory.connectBrowserStack(playwrightThreadLocal.get());

        } else {

            switch (browserName.toLowerCase()) {
                case "firefox":
                    browser =
                            playwrightThreadLocal.get()
                                    .firefox()
                                    .launch(options);
                    break;

                case "webkit":
                    browser =
                            playwrightThreadLocal.get()
                                    .webkit()
                                    .launch(options);
                    break;

                case "chromium":

                default:
                    browser =
                            playwrightThreadLocal.get()
                                    .chromium()
                                    .launch(options);
                    break;
            }
        }

        browserThreadLocal.set(browser);

        BrowserContext context = browser.newContext();
        contextThreadLocal.set(context);

        Page page = context.newPage();

        page.navigate(ConfigReader.getProperty("base.url"));

        pageThreadLocal.set(page);
    }

    public static BrowserContext getContext(){

        return contextThreadLocal.get();
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
        if(getPage() != null)
            getPage().close();

        if(getContext() != null)
            getContext().close();

        if(getBrowser() != null)
            getBrowser().close();

        if(getPlaywright() != null)
            getPlaywright().close();

        pageThreadLocal.remove();
        contextThreadLocal.remove();
        browserThreadLocal.remove();
        playwrightThreadLocal.remove();
    }
}

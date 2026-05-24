package factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import config.ConfigReader;

public class BrowserStackFactory {

    public static Browser connectBrowserStack(
            Playwright playwright) {

        String username =
                ConfigReader.getProperty(
                        "browserstack.username");
        String accessKey =
                ConfigReader.getProperty(
                        "browserstack.accesskey");

        String caps = "{"
                + "\"browser\": \"chrome\","
                + "\"browser_version\": \"latest\","
                + "\"os\": \"windows\","
                + "\"os_version\": \"11\","
                + "\"browserstack.username\": \"" + username + "\","
                + "\"browserstack.accessKey\": \"" + accessKey + "\","
                + "\"client.playwrightVersion\": \"1.latest\","
                + "\"name\": \"Playwright Framework Test\","
                + "\"build\": \"Playwright Build\""
                + "}";

        String wsEndpoint;

        try {

            wsEndpoint =
                    "wss://cdp.browserstack.com/playwright?caps="
                            + java.net.URLEncoder.encode(
                            caps,
                            "UTF-8");

        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return playwright.chromium()
                .connect(wsEndpoint);

    }
}

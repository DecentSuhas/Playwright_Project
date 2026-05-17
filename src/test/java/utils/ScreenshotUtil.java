package utils;

import com.microsoft.playwright.Page;
import java.util.Base64;

public class ScreenshotUtil {

    public static String takeScreenshot(Page page){

        byte[] bytes = page.screenshot(
                new Page.ScreenshotOptions()
                        .setFullPage(false));

        return Base64.getEncoder().encodeToString(bytes);
    }
}

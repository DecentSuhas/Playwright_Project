package utils;

import com.microsoft.playwright.Page;
import factory.BrowserFactory;

import java.util.Base64;

public class ScreenshotUtil {


    public static String captureScreenshot() {

        Page page = BrowserFactory.getPage();

        byte[] screenshotBytes =
                page.screenshot(
                        new Page.ScreenshotOptions()
                                .setFullPage(true));

        return Base64.getEncoder()
                .encodeToString(screenshotBytes);
    }



}

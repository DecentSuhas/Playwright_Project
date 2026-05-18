package utils;

import com.microsoft.playwright.Page;
import factory.BrowserFactory;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(String screenshotName) {

        Page page = BrowserFactory.getPage();

        String timeStamp =
                new SimpleDateFormat(
                        "yyyyMMdd_HHmmss")
                        .format(new Date());

        String path =
                "screenshots/"
                        + screenshotName
                        + "_"
                        + timeStamp
                        + ".png";

        page.screenshot(
                new Page.ScreenshotOptions()
                        .setPath(Paths.get(path))
                        .setFullPage(true));

        return path;
    }
}

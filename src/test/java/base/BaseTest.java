package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ExtentManager;
import utils.ScreenshotUtil;

import java.lang.reflect.Method;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected ExtentReports extentReports;
    protected ExtentTest extentTest;

    @BeforeMethod
    public void setUp(Method method){
        extentReports = ExtentManager.getInstance();
        extentTest = extentReports.createTest(method.getName());
        playwright = Playwright.create();
        browser = playwright.chromium().launch( new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        page = browser.newPage();
    }


    @AfterMethod
    public void tearDown(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){

            extentTest.fail(result.getThrowable());

            String base64Screenshot =
                    ScreenshotUtil.takeScreenshot(page);

            extentTest.fail(
                    MediaEntityBuilder
                            .createScreenCaptureFromBase64String(base64Screenshot)
                            .build()
            );
        } else if (result.getStatus() == ITestResult.SUCCESS){
            extentTest.pass("Test Passed");
        } else{
            extentTest.skip("Test Skipped");
        }
        extentReports.flush();
        if(browser!=null) browser.close();
        if(playwright!=null) playwright.close();
    }

}

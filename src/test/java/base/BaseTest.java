package base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import factory.BrowserFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.lang.reflect.Method;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected ExtentReports extentReports;
    protected ExtentTest extentTest;

    @BeforeMethod
    public void setUp(Method method) {
        BrowserFactory.initBrowser();
        page = BrowserFactory.getPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result){
        if(browser!=null) browser.close();
        if(playwright!=null) playwright.close();
    }

}

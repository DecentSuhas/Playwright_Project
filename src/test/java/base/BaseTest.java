package base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import config.ConfigReader;
import factory.BrowserFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected ExtentReports extentReports;
    protected ExtentTest extentTest;

    @Parameters({"browser", "env", "execution"})

    @BeforeMethod
    public void setup(@Optional String browser, String env, String execution){

        ConfigReader.loadProperties(env);
        BrowserFactory.initBrowser(browser, execution);

        page = BrowserFactory.getPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result){
        if(browser!=null) browser.close();
        if(playwright!=null) playwright.close();
    }

}

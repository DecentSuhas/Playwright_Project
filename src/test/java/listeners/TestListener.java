package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtil;
import utils.ExtentManager;

import com.aventstack.extentreports.*;

public class TestListener implements ITestListener {

    private static ExtentReports extentReports = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Listener triggered");
        ExtentTest test = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.get().pass("Test Passed");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.get().fail(result.getThrowable());
        try {
            String base64Screenshot = ScreenshotUtil.captureScreenshot();
            extentTest.get() .fail("Test Failed", MediaEntityBuilder .createScreenCaptureFromBase64String( base64Screenshot) .build());
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {

        extentReports.flush();
    }
}

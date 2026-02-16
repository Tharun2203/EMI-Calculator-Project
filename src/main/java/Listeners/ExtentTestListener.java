package Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.BaseClass;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;

import java.util.prefs.BackingStoreException;

public class ExtentTestListener extends BaseClass implements ITestListener {

    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> testThread=new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context){
        extent= ExtentReportManager.getReportInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
        testThread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testThread.get().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    }



    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test=testThread.get();
        test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        test.log(Status.FAIL, "Failure Reason: <pre>"+result.getThrowable()+"</pre>");

        String base64Screenshot=ScreenshotUtil.getScreenshot(driver);
        test.addScreenCaptureFromBase64String(base64Screenshot,"Failure Screenshots");
        String screenshotName= result.getMethod().getMethodName()+".png";
        String relativePath="../screenshots/"+screenshotName;

        try{
            test.addScreenCaptureFromPath(relativePath, "Failure Screenshot");
        } catch (Exception e) {
            test.log(Status.WARNING, "Failed to attach screenshot: " + e.getMessage());
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testThread.get().log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}

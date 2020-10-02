package main.java.com.wa.qa.ExtentReportListener;

import com.aventstack.extentreports.*;
import main.java.com.wa.qa.util.TestUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


//Extent Report Declarations

public class ExtentTestNGITestListener implements ITestListener {

    private final ExtentReports extent =  ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();


    @Override
    public synchronized void onStart(ITestContext context) {
        ExtentTest parent = extent.createTest(context.getName());
        parentTest.set(parent);
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
 /*       ExtentTest child = parentTest.get()
                .createNode(result.getMethod().getMethodName() + result.getMethod().getDescription()); */
        ExtentTest child = parentTest.get()
                .createNode(result.getMethod().getMethodName());
        test.set(child);

    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }



    @Override
    public synchronized void onTestFailure(ITestResult result) {
        String path = null;
        try {
            path = TestUtil.takeScreenShot();
            System.out.println(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            test.get()
                    .log(Status.FAIL,
                            result.getThrowable().getMessage(),
                            MediaEntityBuilder.createScreenCaptureFromPath(path).build());
               } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod()
                .getMethodName()));
    }
}

package api.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    // Report Start
    @Override
    public void onStart(ITestContext context) {

        sparkReporter = new ExtentSparkReporter(".\\reports\\API_Automation_Report.html");

        sparkReporter.config().setDocumentTitle("API Automation Report");
        sparkReporter.config().setReportName("PetStore API Testing Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Tester", "Ramvilas");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
    }

    // Test Start
    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getName());
        test.info("Test Started : " + result.getName());
    }

    // Test Pass
    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed : " + result.getName());
    }

    // Test Fail
    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed : " + result.getName());
        test.fail(result.getThrowable());
    }

    // Test Skip
    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped : " + result.getName());
    }

    // Finish Report
    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
        System.out.println("Extent Report Generated Successfully");
    }
}
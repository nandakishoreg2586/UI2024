package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;
    public static ExtentTest test;
    
    public static ExtentReports createInstance(String fileName) {
    	ExtentSparkReporter spark = new ExtentSparkReporter(fileName);
        extent = new ExtentReports();
        extent.attachReporter(spark);
        return extent;
    }

    public static void logTestResult(String testName, String status) {
        test = extent.createTest(testName);
        if (status.equalsIgnoreCase("pass")) {
            test.pass("Test passed");
        } else {
            test.fail("Test failed");
        }
        extent.flush();
    }
}
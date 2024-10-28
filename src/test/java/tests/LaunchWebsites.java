package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pages.LaunchFlipkart;
import utils.BaseTest;
import utils.ZephyrIntegration;



public class LaunchWebsites {
	
	 Logger log = LogManager.getLogger(this.getClass().getName());

//	 String testCaseKey = "NK-T1"; // Jira test case ID

	 WebDriver driver = BaseTest.initialize("chrome");
	 LaunchFlipkart loginFlipkartPge = new LaunchFlipkart(driver);

    @Test(retryAnalyzer = utils.RetryAnalyzer.class, groups = {"smoke"}, dataProvider = "urlData", dataProviderClass = utils.urlData.class)
    /*retryAnalyzer = utils.RetryAnalyzer.class: 
    This annotation attribute tells TestNG to use the RetryAnalyzer 
    class to determine if the test should be retried upon failure. */
    public void testLogin(String urlData) {
    	driver.get(urlData);
    	String Page_title = driver.getTitle();
    	System.out.println("Title of the page is : "+Page_title);
    	
    }
    
//    @AfterMethod
//    public void tearDownAndReport(ITestResult result) {
//        String status = (result.isSuccess()) ? "PASS" : "FAIL";
//        log.info("Updatind results in JIRA");
//        // Report result to Jira Zephyr
//        ZephyrIntegration.postTestResult(testCaseKey, status);
//
//        // Teardown WebDriver
//        driver.quit();
//    }
}
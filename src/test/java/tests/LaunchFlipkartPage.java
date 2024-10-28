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



public class LaunchFlipkartPage {
	
	 Logger log = LogManager.getLogger(this.getClass().getName());

	 String testCaseKey = "NK-T1"; // Jira test case ID

	 WebDriver driver = BaseTest.initialize("chrome");
	 LaunchFlipkart loginFlipkartPge = new LaunchFlipkart(driver);

    @Test(retryAnalyzer = utils.RetryAnalyzer.class, groups = {"smoke"})
    /*retryAnalyzer = utils.RetryAnalyzer.class: 
    This annotation attribute tells TestNG to use the RetryAnalyzer 
    class to determine if the test should be retried upon failure. */
    public void testLogin() {
    	driver.get("https://www.flipkart.com/");
    	driver.manage().window().maximize();
       	loginFlipkartPge = new LaunchFlipkart(driver);
       	log.info("Launching Flipkart");
    	loginFlipkartPge.searchLink();
       	log.info("On search bar clicking on Laptops");
       	loginFlipkartPge.mouseHoverandClick();
       	log.info("Mouse Hovering on Login Icon");
       	loginFlipkartPge.clickFlipkartPlusZone();
       	log.info("Clicking on Flipkart");
    }
    
    @AfterMethod
    public void tearDownAndReport(ITestResult result) {
        String status = (result.isSuccess()) ? "PASS" : "FAIL";
        log.info("Updatind results in JIRA");
        // Report result to Jira Zephyr
        ZephyrIntegration.postTestResult(testCaseKey, status);

        // Teardown WebDriver
        driver.quit();
    }
}
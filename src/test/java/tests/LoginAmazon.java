package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LaunchFlipkart;
import Pages.LoginAmazonHomePage;
import Pages.LoginAmazonPasswordPage;
import Pages.LoginAmazonUsernamePage;
import utils.BaseTest;
import utils.CucumberWebDriverSingleton;
import utils.ZephyrIntegration;

public class LoginAmazon{
	
	 String testCaseKey = "NK-T1"; // Jira test case ID
	 
	 WebDriver driver = BaseTest.initialize("firefox");
	 LoginAmazonHomePage homepage = new LoginAmazonHomePage(driver);
	 LoginAmazonUsernamePage usrpage = new LoginAmazonUsernamePage(driver);
	 LoginAmazonPasswordPage pwdpage = new LoginAmazonPasswordPage(driver);

	 
    @Test(retryAnalyzer = utils.RetryAnalyzer.class, groups = {"regression"},dataProvider = "userData", dataProviderClass = utils.TestDatawithDataProvider.class)
    /*retryAnalyzer = utils.RetryAnalyzer.class: 
    This annotation attribute tells TestNG to use the RetryAnalyzer 
    class to determine if the test should be retried upon failure. */
    public void testLogin(String username, String password) {
    	driver.get("https://www.amazon.in/");
       	homepage.clickSignIN();
       	usrpage.enterUsername(username);
       	usrpage.clickContinueButton();
       	pwdpage.enterpassword(password);
       	pwdpage.clickSignInButton();       	
    }
    
    @AfterMethod
    public void tearDownAndReport(ITestResult result) {
        String status = (result.isSuccess()) ? "PASS" : "FAIL";

        // Report result to Jira Zephyr
        ZephyrIntegration.postTestResult(testCaseKey, status);

        // Teardown WebDriver
        driver.quit();
    }
    
	//Code to handle table rows and columns in a web table using Selenium WebDriver and Java without using TestNG
        //https://www.guru99.com/handling-dynamic-webtables-in-selenium.html
        //https://www.toolsqa.com/selenium-webdriver/handle-dynamic-webtables-in-selenium-webdriver/
    
        
}
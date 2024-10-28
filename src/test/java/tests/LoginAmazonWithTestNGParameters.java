package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LaunchFlipkart;
import Pages.LoginAmazonHomePage;
import Pages.LoginAmazonPasswordPage;
import Pages.LoginAmazonUsernamePage;
import utils.BaseTest;
import utils.CucumberWebDriverSingleton;
import utils.ZephyrIntegration;

public class LoginAmazonWithTestNGParameters{
	
	 String testCaseKey = "NK-T1"; // Jira test case ID
	 
	 WebDriver driver = BaseTest.initialize("edge");
	 LoginAmazonHomePage homepage = new LoginAmazonHomePage(driver);
	 LoginAmazonUsernamePage usrpage = new LoginAmazonUsernamePage(driver);
	 LoginAmazonPasswordPage pwdpage = new LoginAmazonPasswordPage(driver);

	 
    @Test(retryAnalyzer = utils.RetryAnalyzer.class, groups = {"regression"})
    @Parameters({"url","username", "password"})
    /*retryAnalyzer = utils.RetryAnalyzer.class: 
    This annotation attribute tells TestNG to use the RetryAnalyzer 
    class to determine if the test should be retried upon failure. */
    public void testLogin(String url, String username, String password) {
    	driver.get(url);
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
}
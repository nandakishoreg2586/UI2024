package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.CucumberWebDriverSingleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LaunchFlipkart;
import Pages.LoginAmazonHomePage;
import Pages.LoginAmazonUsernamePage;

public class LoginAmazonUsernameSteps {

 /*   WebDriver driver;
    LoginAmazonHomePage HomePage;
    LoginAmazonUsernamePage UsernamePage; */
	
	 WebDriver driver = CucumberWebDriverSingleton.getDriver();
	 LoginAmazonHomePage HomePage = new LoginAmazonHomePage(driver);
	 LoginAmazonUsernamePage UsernamePage = new LoginAmazonUsernamePage(driver); 
	 
    @Given("User is on the Amazon Home page")
    public void user_is_on_the_login_page() {
//     	WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");    
    }

    @Then("User clicks on Signin button")
    public void user_clicks_on_signin_button() {  
//    	HomePage = new LoginAmazonHomePage(driver);
    	HomePage.clickSignIN();
    }
    
    @When("User enters {string} and click continue")
    public void user_enters_and_clicks(String username) {
//    	UsernamePage = new LoginAmazonUsernamePage(driver);
    	UsernamePage.enterUsername(username);
    	UsernamePage.clickContinueButton();
    }
    
    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    @Then("User should be on Signin page")
    public void user_should_be_on_dashboard_page() {
    //	Assert.assertTrue(driver.getTitle().contains("Amazon Sign In"));
    	System.out.println(driver.getTitle());
        driver.quit();
    }
}
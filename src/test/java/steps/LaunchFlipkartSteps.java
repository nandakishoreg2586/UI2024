package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.CucumberWebDriverSingleton;
import utils.CucumberWebdriverManagerPicoContainer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LaunchFlipkart;
import Pages.LoginAmazonHomePage;

public class LaunchFlipkartSteps {

 /*   WebDriver driver;
    LaunchFlipkart loginPage; */
	
  /*  PicoContainer
    public LaunchFlipkartSteps(CucumberWebdriverManagerPicoContainer webDriverManager) {
        this.driver = webDriverManager.getDriver();
        loginPage = new LaunchFlipkart(driver);;
    }
  */
    
    WebDriver driver = CucumberWebDriverSingleton.getDriver();
    LaunchFlipkart loginPage = new LaunchFlipkart(driver);
    
    
    @Given("User is on the Flipkart Home page")
    public void user_is_on_the_login_page() {
//     	WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        
    }

    @When("User click on Login button")
    public void user_click_on_login_button() {
    	loginPage.searchLink();
    }

    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    @Then("User should be on Login page")
    public void user_should_be_on_dashboard_page() {
    	Assert.assertTrue(driver.getTitle().contains("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"));
        driver.quit();
    }
}
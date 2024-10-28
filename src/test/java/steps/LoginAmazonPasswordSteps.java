package steps;

import io.cucumber.java.en.Then;
import utils.CucumberWebDriverSingleton;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.LoginAmazonHomePage;
import Pages.LoginAmazonPasswordPage;
import Pages.LoginAmazonUsernamePage;

public class LoginAmazonPasswordSteps {

  /*  WebDriver driver;
    LoginAmazonPasswordPage loginPasswordPage;  */
    
	 WebDriver driver = CucumberWebDriverSingleton.getDriver();
	 LoginAmazonPasswordPage loginPasswordPage = new LoginAmazonPasswordPage(driver);

    @Then("User is redirected to password page and user enters {string} and click Sign In")
    public void user_is_redirected_to_password_page_and_user_enters_and_click_sign_in(String string) {
    	loginPasswordPage = new LoginAmazonPasswordPage(driver);
    	loginPasswordPage.enterpassword(string);
    	loginPasswordPage.clickSignInButton();
    }

    @Then("User should be on Home page")
    public void user_should_be_on_home_page() {
      	System.out.println(driver.getTitle());
    	Assert.assertTrue(driver.getTitle().contains("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"));
        driver.quit();
    }
}



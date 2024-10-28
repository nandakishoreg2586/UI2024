package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAmazonUsernamePage {
    WebDriver driver;

    // PageFactory to locate elements

    @FindBy(id = "ap_email")
    WebElement email_phonenumber;

    @FindBy(id = "continue")
    WebElement continueButton;

    public LoginAmazonUsernamePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	public void enterUsername(String username) {
        email_phonenumber.sendKeys(username);
    }
        
    public void clickContinueButton() {
        continueButton.click();
    }
}
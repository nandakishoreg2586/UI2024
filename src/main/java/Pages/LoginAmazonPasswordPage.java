package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAmazonPasswordPage {
    WebDriver driver;

    // PageFactory to locate elements
    @FindBy(id = "ap_password")
    WebElement password;

    @FindBy(id = "signInSubmit")
    WebElement signINButton;

    public LoginAmazonPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enterpassword(String username) {
        password.sendKeys(username);
    }
        
    public void clickSignInButton() {
        signINButton.click();
    }
}
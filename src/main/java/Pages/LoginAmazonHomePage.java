package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAmazonHomePage {
    WebDriver driver;

    // PageFactory to locate elements
    @FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement Signinpage;

    public LoginAmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignIN() {
        Signinpage.click();
    }

}
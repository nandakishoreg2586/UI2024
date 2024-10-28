package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaunchFlipkart {
    WebDriver driver;

    // PageFactory to locate elements
    @FindBy(xpath = "//input[@placeholder='Search for Products, Brands and More']")
    WebElement Homepage_Search;
    
    @FindBy(xpath = "//span[normalize-space()='Login']")
    WebElement Login_Icon;
    
    @FindBy(xpath = "//li[normalize-space()='Flipkart Plus Zone']")
    WebElement Flipkart_Plus_Zone;
    
  
    public LaunchFlipkart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchLink() {
    	Homepage_Search.sendKeys("laptops");
    }

	public void mouseHoverandClick() {
		Actions actions = new Actions(driver);
		WebElement element = Login_Icon;
		actions.moveToElement(element).perform();
		// Code to mouse hover and click
	}
	
	public void clickFlipkartPlusZone() {
		Flipkart_Plus_Zone.click();
	}
    
}
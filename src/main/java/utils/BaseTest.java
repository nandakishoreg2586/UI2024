package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

 //   protected WebDriver driver;
    private static WebDriver driver;
    
    private BaseTest() {
    	
    }

    @BeforeMethod
    public static WebDriver initialize(String browser) {
    	switch (browser.toLowerCase()) {
        case "chrome":
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;
        case "edge":
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            break;
        default:
            throw new IllegalArgumentException("Browser type not supported: " + browser);
    }

    // Maximize the browser window and set an implicit wait
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);

//    	
//    	WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
////        driver.get("https://www.amazon.in/");
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    // Getter method to return the driver
	public static WebDriver getDriver() {
		return driver;
	}
    
}
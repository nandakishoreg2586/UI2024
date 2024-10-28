package CucumberRunnerFiles;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.ZephyrIntegration;

@CucumberOptions(
    features = "src/test/java/features",
    glue = "steps",
    plugin = {"pretty", "html:target/cucumber-reports.html","rerun:target/failedrerun.txt"},
    monochrome = true
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
	
//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//	    return super.scenarios();
//	}
	
	public class LoginRunner extends AbstractTestNGCucumberTests {
	}
	
//	@After
//	public void tearDown(Scenario scenario) {
//		WebDriver driver = null;
//	    String status = (scenario.isFailed()) ? "FAIL" : "PASS";
//	    ZephyrIntegration.postTestResult("TEST-123", status);
//	    driver.quit();
//	}
	
}
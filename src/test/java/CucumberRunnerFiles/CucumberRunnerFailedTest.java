package CucumberRunnerFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/failedrerun.txt",
        glue = {"steps"}
)
public class CucumberRunnerFailedTest extends AbstractTestNGCucumberTests {
}
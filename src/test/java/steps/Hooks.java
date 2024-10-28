package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CucumberWebDriverSingleton;

public class Hooks {

    @After
    public void tearDown() {
        CucumberWebDriverSingleton.quitDriver();
    }
}

//Use Cucumber hooks to close the WebDriver after each scenario.


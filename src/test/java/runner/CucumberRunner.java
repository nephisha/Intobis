package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty:STDOUT","html:target/cucumber-reports/","json:target/cucumber-reports/cucumber.json", "junit:target/cucumber-reports/cucumberjunit.xml"},
        junit = "--step-notifications",
        tags = {"@intobis"},
        glue = {"steps"}
)
public class CucumberRunner {

}

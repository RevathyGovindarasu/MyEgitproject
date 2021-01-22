package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = 	"src/test/java/Features/HappyPath.feature"
,glue = {"StepDefinition"},
plugin = { "pretty", "html:target/cucumber-reports" },
monochrome = true
		)
public class TestRunner {

}

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        features="src/test/resources/features/",
        plugin = {"json:target/cucumber-report.json",
                "html:target/cucumber-report"
        })


public class CucumberRunner extends AbstractTestNGCucumberTests {
}

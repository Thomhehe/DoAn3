package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/timkiem.feature",
        glue = {"StepDefinitions"},
        plugin = {"pretty", "html:target/htmlreporttk.html"},
        monochrome = true
)

public class TimkiemRunner {
}

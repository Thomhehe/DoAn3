package testrunners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/lienhe.feature",
        glue = {"StepDefinitions"},
        plugin = {"pretty", "html:target/htmlreportlh.html"},
        monochrome = true
)

public class lienherunner {
}

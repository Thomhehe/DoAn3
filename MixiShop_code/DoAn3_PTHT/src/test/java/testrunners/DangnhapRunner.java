package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/dangnhap.feature",
        glue = {"StepDefinitions"},
        plugin = {"pretty", "html:target/htmlreportdn.html"},
        monochrome = true
)

public class DangnhapRunner {

}

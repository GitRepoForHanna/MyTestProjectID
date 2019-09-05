import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import utils.CustomerRunner;


@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\HannasWorkshop\\src\\test\\resources\\features",
        glue = "steps",
        plugin = {"pretty",
                /*"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",*/
                "com.epam.reportportal.cucumber.StepReporter"},
        tags = "@ForRun")

public class TestRunner {
}

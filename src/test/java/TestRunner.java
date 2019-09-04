import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import utils.CustomerRunner;


@RunWith(CustomerRunner.class)
@CucumberOptions(features = "C:\\HannasWorkshop\\src\\test\\resources\\features",
        glue = "steps",
        plugin = {"pretty", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"/*,"com.epam.reportportal.cucumber.ScenarioReporter"*/},
        tags = "@ForRun")

public class TestRunner {
}
